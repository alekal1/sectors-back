package ee.alekal.sectorsback.controller;


import ee.alekal.sectorsback.entities.UserEntity;
import ee.alekal.sectorsback.entities.dto.UserDto;
import ee.alekal.sectorsback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ee.alekal.sectorsback.util.AppConstants.USER_PATH;

@CrossOrigin("*")  // Should not be used in prod. FIXME: maybe proxy
@RestController
@RequestMapping(path = USER_PATH)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @PostMapping(value = "/add", produces = "application/json")
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/download/{id}/{name}")
    public ResponseEntity<InputStreamResource> downloadUserData(@PathVariable Long id,
                                                                @PathVariable String name) {
        return userService.downloadUserData(id, name);
    }
}
