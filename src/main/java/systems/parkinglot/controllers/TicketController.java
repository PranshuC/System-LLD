package systems.parkinglot.controllers;

import lombok.AllArgsConstructor;
import systems.parkinglot.dtos.IssueTicketRequest;
import systems.parkinglot.models.Ticket;
import systems.parkinglot.services.TicketService;

@AllArgsConstructor
public class TicketController {

    private TicketService service;
    public Ticket createTicket(IssueTicketRequest request) {
        return service.createTicket(request);
    }
}
