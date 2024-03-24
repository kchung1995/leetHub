class Solution {
    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        val n = intervals.size
        val result = IntArray(n)

        for (i in 0 until n) {
            var min: Int = Integer.MAX_VALUE
            var minIndex = -1

            for (j in 0 until n) {
                if (intervals[j][0] >= intervals[i][1]
                    && intervals[j][0] < min
                ) {
                    min = intervals[j][0]
                    minIndex = j
                }
            }

            result[i] = minIndex
        }

        return result
    }
}

