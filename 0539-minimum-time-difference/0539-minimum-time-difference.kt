class Solution {
    fun findMinDifference(timePoints: List<String>): Int {
        val sortedTimePoints = timePoints
            .sorted()
            .map { TimePoint(it) }
        val n = timePoints.size
        var result: Int = getBackwardTimeDifferenceInMinute(sortedTimePoints[0], sortedTimePoints[n - 1])

        for (i in 0 until n - 1) {
            if (result == 0) return result
            result = minOf(result, getForwardTimeDifferenceInMinute(sortedTimePoints[i], sortedTimePoints[i + 1]))
        }

        return result
    }

    private fun getForwardTimeDifferenceInMinute(a: TimePoint, b: TimePoint): Int {
        return b.wholeMinute() - a.wholeMinute()
    }

        private fun getBackwardTimeDifferenceInMinute(a: TimePoint, b: TimePoint): Int {
        return a.wholeMinute() - b.wholeMinute() + 1440
    }
}

@JvmInline
value class TimePoint(val value: String) {
    fun hour(): Int = value.substringBefore(":").toInt()
    fun minute(): Int = value.substringAfter(":").toInt()
    fun wholeMinute(): Int = hour() * 60 + minute()
}
