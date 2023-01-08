class Solution {
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        var result: Int = 0
        
        for (i in 1 until timeSeries.size) {
            if (timeSeries[i] - timeSeries[i - 1] >= duration) {
                result += duration
            }
            else {
                result += (timeSeries[i] - timeSeries[i - 1])
            }
        }
        result += duration
        
        return result
    }
}