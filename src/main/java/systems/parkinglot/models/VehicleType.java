package systems.parkinglot.models;

public enum VehicleType {
    BIKE, CAR, TRUCK;

    public SpotType toSpotType() {

        switch (this) {
            case BIKE:
                return SpotType.SMALL;
            case CAR:
                return SpotType.MEDIUM;
            case TRUCK:
                return SpotType.LARGE;
        }

        throw new RuntimeException("Invalid vehicle type" + this);
    }

}
