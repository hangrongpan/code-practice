package main.java.parking;

public class Bus extends Vehicle {

    public Bus(int spotNeeded, VehicleSize size) {
        this.spotNeeded = spotNeeded;
        this.size = size;
    }

    public Bus() {
        this(5, VehicleSize.Large);
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        if (spot.getSpotSize() == VehicleSize.Large) {
            return true;
        } else {
            return false;
        }
    }
}
