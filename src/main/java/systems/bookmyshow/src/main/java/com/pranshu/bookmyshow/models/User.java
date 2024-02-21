package com.pranshu.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "USERS")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User extends BaseModel {
    private String email;

    public User(LocalDateTime createdAt, LocalDateTime updatedAt, String email) {
        super(createdAt, updatedAt);
        this.email = email;
    }
}

// "user" is a reserved keyword : user table in any database