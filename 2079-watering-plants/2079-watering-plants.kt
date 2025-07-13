class Solution {
    fun wateringPlants(plants: IntArray, capacity: Int): Int {
        var result: Int = 0
        var currentCapacity = capacity

        for (i in 0 until plants.size) {
            if (currentCapacity < plants[i]) {
                result += (i * 2)
                currentCapacity = capacity
            }
            currentCapacity -= plants[i]
        }

        return result + plants.size
    }
}

