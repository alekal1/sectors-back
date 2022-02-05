package ee.alekal.sectorsback.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ee.alekal.sectorsback.dao.SectorRepository;
import ee.alekal.sectorsback.dao.UserRepository;
import ee.alekal.sectorsback.entities.SectorEntity;
import ee.alekal.sectorsback.entities.UserEntity;
import ee.alekal.sectorsback.entities.dto.UserDto;
import ee.alekal.sectorsback.exceptions.sector.SectorNotFoundException;
import ee.alekal.sectorsback.exceptions.user.UserNotFoundException;
import ee.alekal.sectorsback.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static ee.alekal.sectorsback.util.FileUtils.createTempFile;
import static ee.alekal.sectorsback.util.FileUtils.downloadFile;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final SectorRepository sectorRepository;
    private final ServletContext servletContext;
    private final UserMapper mapper;

    public UserEntity getUserById(Long userId) {
        log.info("Getting user with id {}", userId);
        var user = userRepository.findById(userId);

        if (user.isEmpty()) {
            log.error("Cannot find user with id {}", userId);
            throw new UserNotFoundException();
        }
        return userRepository.getById(userId);
    }


    public ResponseEntity<HttpStatus> addUser(UserDto userDto) {
        var entity = mapper.userDtoToEntity(userDto);

        var listOfSectors = getSectors(userDto.getSectorsIds());

        entity.setSectors(listOfSectors);

        userRepository.saveAndFlush(entity);

        log.info("User {} was successfully added", entity);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<InputStreamResource> downloadUserData(String name) {
        var user = userRepository.findByUsername(name);

        if (user == null) {
            throw new UserNotFoundException("User with given name was not found.");
        }

        var filePath = createTempFile("user_" + user.getUsername());
        var file = new File(String.valueOf(filePath));

        try {
            var objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
            objectWriter.writeValue(file, user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        log.info("Downloading user {}", user);

        return downloadFile(file, servletContext);
    }

    private List<SectorEntity> getSectors(List<Long> sectorIds) {
        var listOfSectors = new ArrayList<SectorEntity>();
        sectorIds.forEach(id -> {
            var sector = sectorRepository.findById(id);
            if (sector.isEmpty()) {
                throw new SectorNotFoundException();
            }
            listOfSectors.add(sector.get());
        });
        return listOfSectors;
    }
}
