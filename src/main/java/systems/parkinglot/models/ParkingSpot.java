package systems.parkinglot.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(toBuilder = true)
@Setter
public class ParkingSpot extends BaseModel {
    private SpotType spotType;
    private SpotStatus spotStatus;

    public static ParkingSpot smallAvailable(Long id) {
        return ParkingSpot.builder()
                .id(id)
                .spotType(SpotType.SMALL)
                .spotStatus(SpotStatus.AVAILABLE)
                .build();
    }

    public static ParkingSpot mediumAvailable(Long id) {
        return ParkingSpot.builder()
                .id(id)
                .spotType(SpotType.MEDIUM)
                .spotStatus(SpotStatus.AVAILABLE)
                .build();
    }

    public static ParkingSpot largeAvailable(Long id) {
        return ParkingSpot.builder()
                .id(id)
                .spotType(SpotType.LARGE)
                .spotStatus(SpotStatus.AVAILABLE)
                .build();
    }

}
