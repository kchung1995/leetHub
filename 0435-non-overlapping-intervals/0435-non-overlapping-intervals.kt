class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortWith(compareBy( { it[1] } ))
        intervals.forEach { println("${it[0]} + ${it[1]}") }

        var result: Int = 0
        var boundary: Int = Integer.MIN_VALUE

        intervals.forEach {
            if (it[0] >= boundary) boundary = it[1]
            else result++
        }

        return result
    }
}

