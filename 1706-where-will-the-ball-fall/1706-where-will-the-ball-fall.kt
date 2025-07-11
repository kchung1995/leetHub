class Solution {
    fun findBall(grid: Array<IntArray>): IntArray {
        val n = grid[0].size
        val result = IntArray(n)
        for (i in 0 until n) {
            result[i] = findColumn(row = 0, column = i, grid)
        }
        return result
    }

    private fun findColumn(row: Int, column: Int, grid: Array<IntArray>): Int {
        if (row == grid.size) return column
        val nextColumn = column + grid[row][column]

        if (
            nextColumn < 0 ||
            nextColumn > grid[0].size - 1 ||
            grid[row][column] != grid[row][nextColumn]
        ) return -1
        return findColumn(row + 1, nextColumn, grid)
    }
}

