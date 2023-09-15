data class Point(val x: Int, val y: Int) {
    companion object {
        fun from(point: IntArray): Point {
            return Point(point[0], point[1])
        }
    }
}

class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val distances = points.associate { Pair(Point.from(it), if (it == points[0]) 0 else Int.MAX_VALUE) }.toMutableMap()
        var result: Int = 0
        
        while (distances.isNotEmpty()) {
            val currentPoint = distances.minByOrNull { it.value }!!.key
            result += distances.remove(currentPoint)!!
            
            for (point in distances.keys.toList()) {
                val distance = Math.abs(currentPoint.x - point.x) + Math.abs(currentPoint.y - point.y)
                distances[point] = Math.min(distances[point]!!, distance)
            }
        }
        
        return result
    }
}

