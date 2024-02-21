package com.pranshu.splitwise.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class User extends BaseModel {
    private String name;
    private String phoneNumber;
    private String hashedPassword;
}

// Don't need any annotations for primitive data type fields