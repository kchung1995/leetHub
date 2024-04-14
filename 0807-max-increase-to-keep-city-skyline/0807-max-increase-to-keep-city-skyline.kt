class Solution {
    fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
        val n = grid.size
        val rows = IntArray(n)
        val columns = IntArray(n)

        for (row in 0 until n) {
            for (column in 0 until n) {
                rows[row] = maxOf(rows[row], grid[row][column])
                columns[column] = maxOf(columns[column], grid[row][column])
            }
        }

        val result: Int =
        (0 until n).map { row ->
            (0 until n).map { column ->
                minOf(rows[row], columns[column]) - grid[row][column]
            }
        }
        .flatten()
        .sum()

        return result
    }
}

