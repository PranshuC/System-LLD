package systems.parkinglot.controllers;

import lombok.AllArgsConstructor;
import systems.parkinglot.dtos.CreateLotRequest;
import systems.parkinglot.models.ParkingLot;
import systems.parkinglot.services.ParkingLotService;

@AllArgsConstructor
public class ParkingLotController {

    private ParkingLotService service;

    // Create a parking lot
    public ParkingLot createParkingLot(CreateLotRequest request) {
        validate(request);
        return service.createParkingLot(request.toParkingLot());
    }

    private void validate(CreateLotRequest request) {
        if(request.getNumberOfFloors() == null) {
            throw new RuntimeException("No number of floors");
        }
        if(request.getNumberOfSpotsPerFloor() == null) {
            throw new RuntimeException("No number of spots per floor");
        }
        if(request.getNumberOfGates() == null) {
            throw new RuntimeException("No number of gates");
        }
    }

    public ParkingLot getParkingLot(Long id) {
        return service.getParkingLot(id);
    }

}

// Request -> As flat as possible
// DTO(Data Transfer Objects) OR Request/Response objects
