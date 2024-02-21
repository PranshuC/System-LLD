package com.pranshu.bookmyshow.dtos;

import com.pranshu.bookmyshow.models.User;
import lombok.Getter;

@Getter
public class CreateUserDto {

    private String email;

    public User toUser() {
        User user = new User();
        user.setEmail(email);
        return user;
    }
}
