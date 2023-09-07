package systems.parkinglot.dtos;

import lombok.Builder;
import lombok.Getter;
import systems.parkinglot.models.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class CreateLotRequest {

    private long id;
    private String name;
    private String address;

    private Integer numberOfGates;
    private Integer numberOfFloors;
    private Integer numberOfSpotsPerFloor;

    public ParkingLot toParkingLot() {

        List<ParkingFloor> parkingFloors = new ArrayList<>();
        for (int i = 0; i < numberOfFloors; i++) {

            List<ParkingSpot> parkingSpots  = new ArrayList<>();
            for(int j = 0; j < numberOfSpotsPerFloor; j++) {
                if ( j < (numberOfSpotsPerFloor/3) ) {
                    parkingSpots.add(ParkingSpot.smallAvailable( (long) j));
                } else if (j < (numberOfSpotsPerFloor/3)*2 ) {
                    parkingSpots.add(ParkingSpot.mediumAvailable( (long) j));
                } else {
                    parkingSpots.add(ParkingSpot.largeAvailable( (long) j));
                }
            }
            parkingFloors.add(ParkingFloor.builder()
                    .id( (long) i)
                    .parkingSpots(parkingSpots)
                    .build());
        }

        List<EntryGate> entryGates = new ArrayList<>();
        for (int i = 0; i < numberOfGates/2 ; i++) {
            EntryGate entryGate = EntryGate.builder()
                                    .id( (long) i )
                                    .displayBoard(DisplayBoard.builder()
                                                    .id( (long) i)
                                                    .build())
                                    .operator(new ParkingAttendant())
                                    .build();
            entryGates.add(entryGate);

        }

        List<ExitGate> exitGates = new ArrayList<>();
        for (int i = 0; i < numberOfGates/2 ; i++) {
            ExitGate exitGate = ExitGate.builder()
                                .id( (long) i )
                                .operator(new ParkingAttendant())
                                .build();
            exitGates.add(exitGate);
        }

        ParkingLot parkingLot = ParkingLot.builder()
                                    .id(this.id)
                                    .name(this.name)
                                    .address(this.address)
                                    .floors(parkingFloors)
                                    .entryGates(entryGates)
                                    .exitGates(exitGates)
                                    .build();
        return parkingLot;
    }
}
