package com.pranshu.bookmyshow.models;

import com.pranshu.bookmyshow.enums.TicketStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Ticket extends BaseModel {

    @ManyToOne
    private Show show;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<ShowSeat> seats = new ArrayList<>();

    private Double amount;

    @Enumerated
    private TicketStatus status;


    public Ticket(LocalDateTime createdAt, LocalDateTime updatedAt, Show show, User user, List<ShowSeat> seats, Double amount, TicketStatus status) {
        super(createdAt, updatedAt);
        this.show = show;
        this.user = user;
        this.seats = seats;
        this.amount = amount;
        this.status = status;
    }
}
