class Solution {
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        points.sortBy { it[0] }

        var result: Int = 0
        for (i in 1 until points.size) {
            result = maxOf(result, points[i][0] - points[i - 1][0])
        }
        
        return result
    }
}

