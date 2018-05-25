package main.java.parking;

public class Car extends Vehicle{

    public Car(int spotNeeded, VehicleSize size) {
        this.size = size;
        this.spotNeeded = spotNeeded;
    }

    public Car() {
        this(1, VehicleSize.Compact);
    }

    public boolean canFitInSpot(ParkingSpot spot) {
        if (spot.getSpotSize() == VehicleSize.Large || spot.getSpotSize() == VehicleSize.Compact) {
            return true;
        } else {
            return false;
        }
    }
}
