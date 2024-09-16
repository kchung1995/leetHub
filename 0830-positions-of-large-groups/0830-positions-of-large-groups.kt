class Solution {
    fun largeGroupPositions(s: String): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        var startIndex: Int = 0
        var currentChar: Char = '-'
        val n = s.length

        val intervals = mutableListOf<Interval>()
        (0 until n).forEach { i ->
            if (currentChar != s[i]) {
                currentChar = s[i]
                intervals.add(Interval(startIndex, i - 1))
                startIndex = i
            }
        }
        intervals.add(Interval(startIndex, n - 1))

        return intervals
            .filter { it.isLargeGroup() }
            .map { listOf(it.start, it.end)}
    }

    data class Interval(val start: Int, val end: Int) {
        fun isLargeGroup() = (this.end - this.start + 1) >= 3
    }
}

