package com.company.library.api;

import com.company.library.dto.UserDto;
import com.company.library.dto.requests.UserSaveRequest;
import com.company.library.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserSaveRequest userSaveRequest){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(userSaveRequest));
    }

    @GetMapping("/findByUsername")
    public ResponseEntity<UserDto> findUserByUsername(@RequestParam String username){
        return ResponseEntity.ok(userService.findUserDtoByUsername(username));
    }
}
