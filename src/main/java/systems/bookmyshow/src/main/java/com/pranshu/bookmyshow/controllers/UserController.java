package com.pranshu.bookmyshow.controllers;

import com.pranshu.bookmyshow.dtos.CreateUserDto;
import com.pranshu.bookmyshow.exceptions.InvalidEmailException;
import com.pranshu.bookmyshow.models.User;
import com.pranshu.bookmyshow.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController // Tells spring this is a component
@AllArgsConstructor // Constructor is used for injection
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    // Get a user
    // VERB - endpoint
    // GET - /user/{id}
    @GetMapping("/{id}")
    public User getuser(@PathVariable String id) {
        return userService.getUser(Long.valueOf(id));
    }

    // Create a user
    // POST - /user
    @PostMapping("/")
    // CreateUserDto can be passed to Service layer
    // rather than converting to entity in Controller layer
    public User createUser(@RequestBody CreateUserDto request) {
        // 1. Data validation
        validate(request);
        // 2. Data transformation

        return userService.createUser(request.toUser());
    }

    private void validate(CreateUserDto request) {
        if (request.getEmail() == null) {
            throw new InvalidEmailException("Email is absent!");
        }
    }


}

// Constructor Injection -
// 1. Add Component annotation
// 2. Add constructors

// Setter Injection
/*public void setUserService(UserService userService) {
    this.userService = userService;
}*/

// Field Injection - not recommended
// @Autowired
// private UserService userService;
