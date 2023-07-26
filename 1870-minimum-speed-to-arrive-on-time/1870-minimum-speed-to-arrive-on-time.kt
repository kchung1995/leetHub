class Solution {
    fun minSpeedOnTime(dist: IntArray, hour: Double): Int {
        var left: Int = 1
        var right: Int = 10000000

        var minSpeed: Int = -1
        var mid: Int = -1

        while (left <= right) {
            mid = left + (right - left) / 2

            if (timeNeeded(mid, dist) <= hour) {
                minSpeed = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return minSpeed
    }

    private fun timeNeeded(speed: Int, dist: IntArray): Double {
        var result: Double = 0.0
        val doubleSpeed = speed.toDouble()

        for (i in 0 until dist.size) {
            val t: Double = dist[i].toDouble() / doubleSpeed
            result += when (i == dist.size - 1) {
                true -> t
                else -> Math.ceil(t)
            }
        }

        return result
    }
}
