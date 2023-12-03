data class Point(val x: Int, val y: Int)

class Solution {
    fun findMinArrowShots(pointsOriginal: Array<IntArray>): Int {
        if (pointsOriginal.isEmpty()) return 0
        val points = pointsOriginal.map { 
            Point(it[0], it[1])
        }.sortedBy { it.y }

        var arrows = 1
        var xStart: Int
        var xEnd: Int
        var firstEnd = points[0].y
        for (p in points) {
            xStart = p.x
            xEnd = p.y

            if (firstEnd < xStart) {
                arrows++
                firstEnd = xEnd
            }
        }

        return arrows
    }
}

