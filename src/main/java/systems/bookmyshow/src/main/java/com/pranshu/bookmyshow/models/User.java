package com.pranshu.bookmyshow.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Date;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "USERS")
public class User extends BaseModel {
    private String email;

    public User(Date createdAt, Date updatedAt, String email) {
        super(createdAt, updatedAt);
        this.email = email;
    }
}

