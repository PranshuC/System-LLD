package com.pranshu.bookmyshow.controllers;

import com.pranshu.bookmyshow.dtos.CreateTicketDto;
import com.pranshu.bookmyshow.models.Ticket;
import com.pranshu.bookmyshow.services.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TicketController {

    private TicketService ticketService;

    //Create a ticket
    @PostMapping("/ticket")
    public Ticket createTicket(CreateTicketDto request) {
        return ticketService.createTicket(request);
    }
}
