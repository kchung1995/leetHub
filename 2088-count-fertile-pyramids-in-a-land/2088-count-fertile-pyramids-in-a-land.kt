class Solution {
    fun countPyramids(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val reversedRowsGrid = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                reversedRowsGrid[m - i - 1][j] = grid[i][j]
            }
        }

        return calculate(grid) + calculate(reversedRowsGrid)
    }

    private fun calculate(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        var result: Int = 0

        for (i in 1 until m) {
            var count: Int = 0
            for (j in 0 until n) {
                if (grid[i][j] == 0) count = 0 else count++
                if (count == 0 || j == 0) continue

                grid[i][j] = minOf(grid[i - 1][j - 1] + 1, (count + 1) shr 1)
                result += grid[i][j] - 1
            }
        }

        return result
    }
}

