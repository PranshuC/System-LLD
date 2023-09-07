package systems.parkinglot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import systems.parkinglot.controllers.ParkingLotController;
import systems.parkinglot.controllers.TicketController;
import systems.parkinglot.dtos.CreateLotRequest;
import systems.parkinglot.dtos.IssueTicketRequest;
import systems.parkinglot.models.ParkingLot;
import systems.parkinglot.models.ParkingSpot;
import systems.parkinglot.models.SpotStatus;
import systems.parkinglot.models.Ticket;
import systems.parkinglot.models.VehicleType;
import systems.parkinglot.repositories.ParkingLotRepository;
import systems.parkinglot.repositories.ParkingSpotRepository;
import systems.parkinglot.repositories.TicketRepository;
import systems.parkinglot.services.ParkingLotService;
import systems.parkinglot.services.ParkingSpotService;
import systems.parkinglot.services.TicketService;
import systems.parkinglot.services.VehicleService;

public class ParkingLotTest {

    private ParkingSpotRepository parkingSpotRepository;
    private ParkingSpotService parkingSpotService;
    private ParkingLotService parkingLotService;
    private ParkingLotRepository parkingLotRepository;
    private ParkingLotController parkingLotController;
    private TicketController ticketController;
    private TicketService ticketService;
    private TicketRepository ticketRepository;

    @Before
    public void setup() {
        parkingSpotRepository = new ParkingSpotRepository();
        parkingSpotService = new ParkingSpotService(parkingSpotRepository);
        parkingLotRepository = new ParkingLotRepository();
        parkingLotService = new ParkingLotService(parkingLotRepository, parkingSpotService);
        parkingLotController = new ParkingLotController(parkingLotService);
        ticketRepository = new TicketRepository();
        ticketService = new TicketService(new VehicleService(), parkingSpotService, ticketRepository);
        ticketController = new TicketController(ticketService);
    }

    @Test
    public void testCreateParkingLot() {

        CreateLotRequest request = createLotRequest();
        ParkingLot actual = parkingLotController.createParkingLot(request);

        assertParkingLot(request, actual);
    }

    @Test
    public void testCreateAndGet() {
        CreateLotRequest request = createLotRequest();
        ParkingLot expected = parkingLotController.createParkingLot(request);

        ParkingLot actual = parkingLotController.getParkingLot(expected.getId());

        assertParkingLot(request, actual);
    }

    @Test
    public void testCreateAndGetSpots() {
        CreateLotRequest request = createLotRequest();
        ParkingLot expected = parkingLotController.createParkingLot(request);

        ParkingLot actual = parkingLotController.getParkingLot(expected.getId());
        List<ParkingSpot> parkingSpots = parkingSpotService.getParkingSpots(actual.getId());

        assertEquals("If parking lot is created, then parking spots should be created",
                request.getNumberOfFloors() * request.getNumberOfSpotsPerFloor(), parkingSpots.size());

    }

    @Test
    public void testAllocation() {
        CreateLotRequest request = createLotRequest();
        ParkingLot lot = parkingLotController.createParkingLot(request);

        ParkingSpot allocatedSlot = parkingSpotService.allocateSlot(lot.getId(), VehicleType.CAR);
        assertNotNull("If parking spots are available, then allocation should be successful", allocatedSlot);
    }

    @Test
    public void testIssueTicket() {
        CreateLotRequest request = createLotRequest();
        ParkingLot lot = parkingLotController.createParkingLot(request);

        Ticket ticket = ticketController.createTicket(
                IssueTicketRequest
                        .builder().parkingLotId(lot.getId())
                        .vehicleNumber("MH-12-AB-1234")
                        .vehicleType(VehicleType.CAR)
                        .entryGateId(1L)
                        //.issuerId(1L)
                        .build());

        assertNotNull("If parking spots are available, then allocation should be successful",
                ticket.getParkingSpotId());

        ParkingSpot actual = parkingSpotService.getParkingSpot(ticket.getParkingSpotId());
        assertEquals("If ticket is issued, then parking spot should be allocated", SpotStatus.FILLED,
                actual.getSpotStatus());
    }

    private static CreateLotRequest createLotRequest() {
        return CreateLotRequest
                .builder()
                .id(1L)
                .name("ABC Parking")
                .address("ABC Street")
                .numberOfFloors(2)
                .numberOfSpotsPerFloor(10)
                .numberOfGates(2)
                .build();
    }

    private static void assertParkingLot(CreateLotRequest request, ParkingLot actual) {

        assertNotNull("If parking lot is created, it should not be null", actual);

        assertEquals("If parking lot is created, it should have same id as requested",
                Optional.of(request.getId()), Optional.of(actual.getId()));

        assertEquals("If parking lot is created, it should have same number of floors as requested",
                Optional.of(request.getNumberOfFloors()), Optional.of(actual.getFloors().size()));

        assertEquals("If parking lot is created, it should have same number of slots per floor as requested",
                Optional.of(request.getNumberOfSpotsPerFloor()), Optional.of(actual.getFloors().get(0).getParkingSpots().size()));

        assertEquals("If parking lot is created, it should have same number of entry gates as requested",
                Optional.of(request.getNumberOfGates()/2), Optional.of(actual.getEntryGates().size()));
    }

}
