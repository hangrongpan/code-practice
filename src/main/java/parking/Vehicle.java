package main.java.parking;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    protected List<ParkingSpot> spots = new ArrayList<>();
    protected VehicleSize size;
    protected String plateNumber;
    protected int spotNeeded;

    public VehicleSize getSize() {
        return size;
    }

    public int getSpotNeeded() {
        return spotNeeded;
    }

    public void parkInSpot(ParkingSpot s) {
        spots.add(s);
    }

    public void removeSpot() {
        // TO remove all the spot occupied by this vehicle, and notify all the spot as not parked.
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);
}
