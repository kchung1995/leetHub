class Solution {
    fun maxDistToClosest(seats: IntArray): Int {
        val n = seats.size
        var previous: Int = -1
        var next: Int = 0
        var result: Int = 0

        for (i in 0 until n) {
            if (seats[i] == 1) {
                previous = i
                continue
            }
            
            while (next < n && seats[next] == 0 || next < i) {
                next++
            }
            val left = if (previous == -1) n else i - previous
            val right = if (next == n) n else next - i
            result = maxOf(result, minOf(left, right))
        }

        return result
    }
}

