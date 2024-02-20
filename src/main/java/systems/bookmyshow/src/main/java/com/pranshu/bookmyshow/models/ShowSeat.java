package com.pranshu.bookmyshow.models;

import com.pranshu.bookmyshow.enums.SeatStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Getter
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

    public ShowSeat(Date createdAt, Date updatedAt, Double price, SeatStatus status, Seat seat, Show show) {
        super(createdAt, updatedAt);
        this.price = price;
        this.status = status;
        this.seat = seat;
        this.show = show;
    }
}
