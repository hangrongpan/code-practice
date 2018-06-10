package ood.parking;

public class ParkingSpot {
    protected VehicleSize spotSize;
    protected int level;
    protected int row;
    protected int num;
    protected Vehicle vehicle;

    public ParkingSpot(int l, int r, int n, VehicleSize s) {
        level = l;
        row = r;
        num = n;
        spotSize = s;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }

    public boolean park(Vehicle vehicle) {
        if (canFitInVehicle(vehicle)) {
            // park logic
            return true;
        }
        return false;
    }

    public boolean canFitInVehicle(Vehicle vehicle) {
        if(vehicle.canFitInSpot(this)) {
            return true;
        }
        return false;
    }

    public void removeCar() {
        // remove the vehicle from the spot , and notify the spot is available.
    }
}
