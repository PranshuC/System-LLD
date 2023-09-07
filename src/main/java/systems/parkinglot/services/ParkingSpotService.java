package systems.parkinglot.services;

import lombok.AllArgsConstructor;
import systems.parkinglot.models.ParkingLot;
import systems.parkinglot.models.ParkingSpot;
import systems.parkinglot.models.VehicleType;
import systems.parkinglot.repositories.ParkingSpotRepository;

import java.util.List;

@AllArgsConstructor
public class ParkingSpotService {

    private ParkingSpotRepository repository;
    public void createParkingSpots(ParkingLot parkingLot) {
        repository.saveParkingSpots(parkingLot);
    }

    public ParkingSpot allocateSpot(Long parkingLotId, VehicleType vehicleType) {
        return repository.findOneByVehicleTypeAndStatusAvailable(vehicleType);
    }

    public ParkingSpot getParkingSpot(Long id) {
        return repository.getParkingSpot(id);
    }

    public ParkingSpot allocateSlot(Long parkingLotId, VehicleType vehicleType) {
        return repository.allocateSlot(parkingLotId, vehicleType);
    }

    public void update(ParkingSpot spot) {
    }

    public List<ParkingSpot> getParkingSpots(Long id) {
        return repository.getParkingSpots();
    }
}
