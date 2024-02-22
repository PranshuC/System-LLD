package com.pranshu.splitwise.controllers;

import com.pranshu.splitwise.dtos.CreateUserDto;
import com.pranshu.splitwise.dtos.GetUserDto;
import com.pranshu.splitwise.models.User;
import com.pranshu.splitwise.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @PostMapping("/")
    public GetUserDto createUser(@RequestBody CreateUserDto user) {
        validate(user);
        return GetUserDto.from(userService.createUser(user));
    }

    private static void validate(CreateUserDto user) {
        if (user.getName() == null) {
            throw new RuntimeException("No name present!");
        }

        if (user.getPassword() == null) {
            throw new RuntimeException("No password present!");
        }
    }

    @GetMapping("/{id}")
    public GetUserDto getUser(@PathVariable Long id) {
        return GetUserDto.from(userService.getUser(id));
    }


}
