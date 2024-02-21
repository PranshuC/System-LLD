package com.pranshu.bookmyshow.services;

import com.pranshu.bookmyshow.dtos.CreateTicketDto;
import com.pranshu.bookmyshow.enums.SeatStatus;
import com.pranshu.bookmyshow.enums.TicketStatus;
import com.pranshu.bookmyshow.exceptions.SeatUnavailableException;
import com.pranshu.bookmyshow.models.ShowSeat;
import com.pranshu.bookmyshow.models.Ticket;
import com.pranshu.bookmyshow.repositories.TicketRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    private ShowSeatService showSeatService;
    private UserService userService;

    @Transactional
    public Ticket createTicket(CreateTicketDto request) {
        // Check for seat availability
        List<ShowSeat> showSeats = showSeatService.getSeats(request.getShowSeatIds());
        checkAvailability(showSeats);

        // Mark the seats as blocked
        showSeatService.lockSeats(showSeats);

        // Create and persist the ticket
        Ticket ticket = new Ticket();
        ticket.setStatus(TicketStatus.PENDING);
        ticket.setUser(userService.getUser(request.getUserId()));
        ticket.setSeats(showSeats);

        return ticketRepository.save(ticket);
    }

    private void checkAvailability(List<ShowSeat> showSeats) {
        // Iterate over seats and check if all are available
        for (ShowSeat seat : showSeats) {
            if(seat.getStatus() != SeatStatus.AVAILABLE) {
                throw new SeatUnavailableException(seat.getId());
            }
        }
    }
}

// Locks - One machine
// Server can run on multiple machines
// Distributed locks
// Transactions
// Isolation Level - Serializable