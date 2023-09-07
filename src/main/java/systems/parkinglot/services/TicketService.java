package systems.parkinglot.services;

import lombok.AllArgsConstructor;
import systems.parkinglot.dtos.IssueTicketRequest;
import systems.parkinglot.models.ParkingSpot;
import systems.parkinglot.models.SpotStatus;
import systems.parkinglot.models.Ticket;
import systems.parkinglot.repositories.TicketRepository;

import java.time.LocalDateTime;

@AllArgsConstructor
public class TicketService {

    private VehicleService vehicleService;
    private ParkingSpotService spotService;
    private TicketRepository repository;
    public Ticket createTicket(IssueTicketRequest request) {

        //Check if parking lot is full
        ParkingSpot spot = spotService.allocateSpot(request.getParkingLotId(), request.getVehicleType());
        if (spot == null) {
            throw new RuntimeException("Spot not available");
        }

        // Update spot status
        spot.setSpotStatus(SpotStatus.FILLED);

        // Persist the spot
        spotService.update(spot);

        // Create the ticket
        Ticket ticket = Ticket.builder()
                .entryTime(LocalDateTime.now())
                .parkingSpotId(spot.getId())
                .entryGateId(request.getEntryGateId())
                .vehicle(vehicleService.findOrCreate(request.getVehicleNumber(), request.getVehicleType()))
                .build();

        return repository.save(ticket);
    }
}
