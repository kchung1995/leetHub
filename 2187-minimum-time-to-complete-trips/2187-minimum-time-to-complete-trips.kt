class Solution {
    fun minimumTime(time: IntArray, totalTrips: Int): Long {
        var left: Long = 0L
        var right: Long = totalTrips.toLong() * time[0]
        var mid: Long = -1L
        
        while (left < right) {
            mid = left + ((right - left) / 2)
            val currentTrips = time.map { mid / it }.sum()
            
            if (currentTrips >= totalTrips)
                right = mid
            else left = mid + 1
        }
        
        return left
    }
}