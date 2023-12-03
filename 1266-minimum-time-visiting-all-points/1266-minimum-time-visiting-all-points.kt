data class Point(val x: Int, val y: Int)

class Solution {
    fun minTimeToVisitAllPoints(pointsOriginal: Array<IntArray>): Int {
        val points = pointsOriginal.map {
            Point(it[0], it[1])
        }
        var result: Int = 0
        for (i in 0 until points.size - 1) {
            val diffX = absolute(points[i + 1].x - points[i].x)
            val diffY = absolute(points[i + 1].y - points[i].y)

            result += maxOf(diffX, diffY)
        }

        return result
    }

    private fun absolute(x: Int) = if (x < 0) -x else x
}

