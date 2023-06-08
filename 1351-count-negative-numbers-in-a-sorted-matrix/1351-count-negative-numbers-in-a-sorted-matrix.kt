class Solution {
    fun countNegatives(grid: Array<IntArray>): Int {
        val n = grid[0].size
        var currentRowNegativeIndex = n - 1

        var result: Int = 0
        for (row in grid) {
            while (currentRowNegativeIndex >= 0 && row[currentRowNegativeIndex] < 0) currentRowNegativeIndex--
            result += (n - (currentRowNegativeIndex + 1))
        }
        return result
    }
}

