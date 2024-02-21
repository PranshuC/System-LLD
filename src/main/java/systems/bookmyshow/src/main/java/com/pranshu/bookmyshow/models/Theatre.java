package com.pranshu.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Theatre extends BaseModel {

    private String name;
    private String address;

    @OneToMany
    private List<Hall> halls = new ArrayList<>();

    @OneToMany
    private List<Show> shows = new ArrayList<>();

    public Theatre(LocalDateTime createdAt, LocalDateTime updatedAt, String name, String address, List<Hall> halls, List<Show> shows) {
        super(createdAt, updatedAt);
        this.name = name;
        this.address = address;
        this.halls = halls;
        this.shows = shows;
    }
}
