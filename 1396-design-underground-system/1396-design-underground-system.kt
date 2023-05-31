class UndergroundSystem() {

    val check = mutableMapOf<Int, Pair<String, Int>>()
    val travel = mutableMapOf<Pair<String, String>, Pair<Int, Int>>()
    
    fun checkIn(id: Int, stationName: String, t: Int) {
        check[id] = Pair(stationName, t)
    }

    fun checkOut(id: Int, stationName: String, t: Int) {
        val current = check[id]!!
        val direction = Pair(current.first, stationName)
        
        when (travel.containsKey(direction)) {
            true -> {
                val previous = travel[direction]!!
                travel[direction] = Pair(previous.first + t - current.second, previous.second + 1)
            }
            else -> travel[direction] = Pair(t - current.second, 1)
        }
    }

    fun getAverageTime(startStation: String, endStation: String): Double {
        val pair = travel[Pair(startStation, endStation)]!!
        return pair.first.toDouble() / pair.second.toDouble()
    }

}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */

