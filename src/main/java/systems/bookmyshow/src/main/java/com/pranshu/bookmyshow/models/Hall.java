package com.pranshu.bookmyshow.models;

import com.pranshu.bookmyshow.enums.MovieFeature;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Hall extends BaseModel {

    private Integer hallNumber;

    @ElementCollection
    @Enumerated
    private List<MovieFeature> features = new ArrayList<>();

    public Hall(Date createdAt, Date updatedAt, Integer hallNumber) {
        super(createdAt, updatedAt);
        this.hallNumber = hallNumber;
    }
}
