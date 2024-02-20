package com.pranshu.bookmyshow.models;

import com.pranshu.bookmyshow.enums.PaymentMode;
import com.pranshu.bookmyshow.enums.PaymentStatus;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class Payment extends BaseModel {

    @Enumerated
    private PaymentMode mode;

    @Enumerated
    private PaymentStatus status;
    private Double amount;
    private String referenceId;

    @ManyToOne
    private Ticket ticket;

    public Payment(Date createdAt, Date updatedAt, String referenceId, Double amount, PaymentMode mode, PaymentStatus status, Ticket ticket) {
        super(createdAt, updatedAt);
        this.referenceId = referenceId;
        this.amount = amount;
        this.mode = mode;
        this.status = status;
        this.ticket = ticket;
    }
}
