package com.pranshu.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class City extends BaseModel {

    private String name;

    @OneToMany
    private List<Theatre> theatres = new ArrayList<>();

    public City(Date createdAt, Date updatedAt, String name) {
        super(createdAt, updatedAt);
        this.name = name;
    }
}
