package com.pranshu.bookmyshow.models;

import com.pranshu.bookmyshow.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Seat extends BaseModel {

    private Integer rowNumber;
    private Integer columnNumber;

    @Enumerated
    private SeatType type;

    public Seat(LocalDateTime createdAt, LocalDateTime updatedAt, Integer row, Integer column, SeatType type) {
        super(createdAt, updatedAt);
        this.rowNumber = row;
        this.columnNumber = column;
        this.type = type;
    }
}
