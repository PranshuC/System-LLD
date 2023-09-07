package systems.parkinglot.dtos;

import lombok.Builder;
import lombok.Getter;
import systems.parkinglot.models.VehicleType;

@Getter
@Builder
public class IssueTicketRequest {

    private Long parkingLotId;
    private String vehicleNumber; //GetOrCreate - Fetch existing or create new vehicle
    private VehicleType vehicleType;
    private Long entryGateId;
}
