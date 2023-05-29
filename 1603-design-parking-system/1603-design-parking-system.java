class ParkingSystem {
    
    int[] parkingLots;

    public ParkingSystem(int big, int medium, int small) {
        parkingLots = new int[4];
        parkingLots[1] = big;
        parkingLots[2] = medium;
        parkingLots[3] = small;
    }
    
    public boolean addCar(int carType) {
        return parkingLots[carType]-- > 0;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */