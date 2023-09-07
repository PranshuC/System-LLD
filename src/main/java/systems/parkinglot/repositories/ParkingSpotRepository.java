package systems.parkinglot.repositories;

import systems.parkinglot.models.*;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotRepository {

    List<ParkingSpot> parkingSpots = new ArrayList<>();

    public void saveParkingSpots(ParkingLot parkingLot) {
        if(parkingLot != null) {
            List<ParkingFloor> parkingFloors = parkingLot.getFloors();
            for(ParkingFloor parkingFloor : parkingFloors) {
                parkingSpots.addAll(parkingFloor.getParkingSpots());
            }
        }
    }

    public ParkingSpot findOneByVehicleTypeAndStatusAvailable(VehicleType vehicletype) {
        for(ParkingSpot spot : parkingSpots) {
            if(spot.getSpotStatus() == SpotStatus.AVAILABLE) {
                return spot;
            }
        }
        return null;
    }

    public ParkingSpot getParkingSpot(Long id) {
        for(ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.getId().equals(id)) {
                parkingSpot.setSpotStatus(SpotStatus.FILLED);
                return parkingSpot;
            }
        }
        return null;
    }

    public ParkingSpot allocateSlot(Long parkingLotId, VehicleType vehicleType) {
        for(ParkingSpot parkingSpot : parkingSpots) {
            if(parkingSpot.getSpotType().equals(vehicleType.toSpotType())) {
                parkingSpot.setSpotStatus(SpotStatus.FILLED);
                return parkingSpot;
            }
        }
        return null;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}
