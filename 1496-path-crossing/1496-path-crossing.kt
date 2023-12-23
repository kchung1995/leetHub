data class Point(val x: Int, val y: Int)

class Solution {
    fun isPathCrossing(path: String): Boolean {
        var currentLocation = Point(0, 0)
        val visited = hashSetOf<Point>()
        visited.add(currentLocation)

        for (d in path) {
            currentLocation = movedPoint(d, currentLocation)
            if (visited.contains(currentLocation)) return true
            visited.add(currentLocation)
        }

        return false
    }

    private fun movedPoint(d: Char, original: Point): Point {
        return when(d) {
            'N' -> Point(original.x, original.y - 1)
            'S' -> Point(original.x, original.y + 1)
            'E' -> Point(original.x + 1, original.y)
            'W' -> Point(original.x - 1, original.y)
            else -> original
        }
    }
}

