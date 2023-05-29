class ParkingSystem(big: Int, medium: Int, small: Int) {
    val current = intArrayOf(big, medium, small)
    fun addCar(carType: Int): Boolean = if (current[carType - 1]-- > 0) true else false
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * var obj = ParkingSystem(big, medium, small)
 * var param_1 = obj.addCar(carType)
 */

