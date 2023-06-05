class Solution {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val dy = yDiff(coordinates[1], coordinates[0])
        val dx = xDiff(coordinates[1], coordinates[0])

        for (i in 2 until coordinates.size) {
            val first = dy * xDiff(coordinates[i], coordinates[0])
            val second = dx * yDiff(coordinates[i], coordinates[0])
            if (first != second) return false
        }
        return true
    }

    private fun xDiff(a: IntArray, b: IntArray) = a[0] - b[0]

    private fun yDiff(a: IntArray, b: IntArray) = a[1] - b[1]
}

