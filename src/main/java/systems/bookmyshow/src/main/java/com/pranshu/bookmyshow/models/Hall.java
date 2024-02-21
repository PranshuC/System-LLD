package com.pranshu.bookmyshow.models;

import com.pranshu.bookmyshow.enums.MovieFeature;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Hall extends BaseModel {

    private Integer hallNumber;

    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();

    public Hall(LocalDateTime createdAt, LocalDateTime updatedAt, Integer hallNumber) {
        super(createdAt, updatedAt);
        this.hallNumber = hallNumber;
    }
}
