package ee.alekal.sectorsback.service;


import ee.alekal.sectorsback.dao.SectorRepository;
import ee.alekal.sectorsback.entities.SectorEntity;
import ee.alekal.sectorsback.exceptions.sector.SectorNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static ee.alekal.sectorsback.entities.enums.SectorType.LOW;
import static ee.alekal.sectorsback.entities.enums.SectorType.MEDIUM;
import static ee.alekal.sectorsback.entities.enums.SectorType.TOP;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SectorService {

    private final SectorRepository sectorRepository;


    public List<SectorEntity> getAllSectors() {
        log.info("Getting all sectors");
        return sectorRepository.findAll();
    }

    public ResponseEntity<List<SectorEntity>> getSectorsByType(String type) {
        log.info("Looking for sector with type {}", type);
        if (typeExists(type)) {
            return new ResponseEntity<>(sectorRepository.findAllByType(type), HttpStatus.OK);
        }
        throw new SectorNotFoundException("Sector with given type was not founded");
    }

    private boolean typeExists(String type) {
        var listOfTypes = List.of(
                TOP.getType(),
                MEDIUM.getType(),
                LOW.getType()
        );

        return listOfTypes.contains(type);
    }
}
