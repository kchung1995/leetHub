class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        val overlappingList = mutableListOf<IntArray>()

        if (intervals.isEmpty()) return listOf(newInterval).toTypedArray()

        var hasStartedOverlapping: Boolean = false
        var hasOverlapped: Boolean = false
        for (next in intervals) {
            if (!isOverlapping(next, newInterval)) {
                if (hasStartedOverlapping) {
                    result.add(buildNewInterval(overlappingList, newInterval))
                    hasStartedOverlapping = false
                }
                result.add(next)
            }
            else {
                hasStartedOverlapping = true
                hasOverlapped = true
                overlappingList.add(next)
            }
        }

        if (hasStartedOverlapping) {
            result.add(buildNewInterval(overlappingList, newInterval))
            hasStartedOverlapping = false
        }
        if (!hasOverlapped) {
            result.add(newInterval)
            result.sortBy { it[0] }
        }

        return result.toTypedArray()
    }

    private fun buildNewInterval(overlapping: List<IntArray>, newInterval: IntArray): IntArray {
        val result = IntArray(2)
        result[0] = minOf(overlapping[0][0], newInterval[0])
        result[1] = maxOf(overlapping.last()[1], newInterval[1])
        return result
    }

    private fun isOverlapping(first: IntArray, second: IntArray): Boolean {
        if (first[0] < second[0] && first[1] < second[0]) return false
        if (second[0] < first[0] && second[1] < first[0]) return false
        return true
    }
}
