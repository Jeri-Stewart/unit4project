package com.devmountain.noteApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.devmountain.noteApp.dtos.UserDto;
import com.devmountain.noteApp.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // To register a new user
    @PostMapping("/register")
    public List<String> addUser(@RequestBody UserDto userDto){
        String passHash = passwordEncoder.encode(userDto.getPassword());
        userDto.setPassword(passHash);
        return userService.addUser(userDto);
    }

    // To log in a user
    @PostMapping("/login")
    public List<String> userLogin(@RequestBody UserDto userDto) {
        return userService.userLogin(userDto);
    }

}
