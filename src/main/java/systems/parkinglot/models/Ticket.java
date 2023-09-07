package systems.parkinglot.models;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Ticket extends BaseModel {

    private Long vehicleId;
    private Vehicle vehicle;

    private Long parkingSpotId;
    private ParkingSpot parkingSpot;

    private LocalDateTime entryTime;

    private Long issuerId;
    private ParkingAttendant issuedBy;

    private Long entryGateId;
    private Gate entryGate;
}
