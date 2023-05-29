class ParkingSystem {
private:
    int current[3];
public:
    ParkingSystem(int big, int medium, int small) {
        current[0] = big; current[1] = medium; current[2] = small;
    }
    
    bool addCar(int carType) {
        if (current[carType - 1]-- > 0) return true; else return false;
    }
};

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem* obj = new ParkingSystem(big, medium, small);
 * bool param_1 = obj->addCar(carType);
 */

