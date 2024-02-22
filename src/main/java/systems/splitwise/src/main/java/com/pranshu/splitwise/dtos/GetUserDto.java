package com.pranshu.splitwise.dtos;

import com.pranshu.splitwise.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetUserDto {
    private String name;
    private String phoneNumber;

    public static GetUserDto from(User user) {
        if (user == null) {
            return null;
        }
        return new GetUserDto(user.getName(), user.getPhoneNumber());
    }
}
