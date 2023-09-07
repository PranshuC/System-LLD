package systems.parkinglot.repositories;

import systems.parkinglot.models.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotRepository {

    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingLot save(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
        return parkingLot;
    }

    public ParkingLot get(Long id) {
        for(ParkingLot parkingLot : parkingLots) {
            if(parkingLot.getId().equals(id))
                return parkingLot;
        }
        return null;
    }
}
