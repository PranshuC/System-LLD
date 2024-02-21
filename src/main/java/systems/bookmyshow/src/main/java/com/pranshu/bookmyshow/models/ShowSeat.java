package com.pranshu.bookmyshow.models;

import com.pranshu.bookmyshow.enums.SeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ShowSeat extends BaseModel {

    private Double price;

    @Enumerated
    private SeatStatus status;

    @ManyToOne
    private Seat seat;

    @ManyToOne
    private Show show;

    public ShowSeat(LocalDateTime createdAt, LocalDateTime updatedAt, Double price, SeatStatus status, Seat seat, Show show) {
        super(createdAt, updatedAt);
        this.price = price;
        this.status = status;
        this.seat = seat;
        this.show = show;
    }
}
