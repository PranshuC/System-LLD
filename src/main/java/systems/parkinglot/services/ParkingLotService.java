package systems.parkinglot.services;

import lombok.AllArgsConstructor;
import systems.parkinglot.models.ParkingLot;
import systems.parkinglot.repositories.ParkingLotRepository;

@AllArgsConstructor
public class ParkingLotService {

    private ParkingLotRepository repository;
    private ParkingSpotService parkingSpotService;
    public ParkingLot createParkingLot(ParkingLot parkingLot) {
        ParkingLot persistedLot = repository.save(parkingLot);

        //Create associated entities - floors, spots, gates
        parkingSpotService.createParkingSpots(persistedLot);
        return persistedLot;
    }

    public ParkingLot getParkingLot(Long id) {
        return repository.get(id);
    }
}
