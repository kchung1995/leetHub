class Solution {
    private val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))

    fun latestDayToCross(row: Int, col: Int, cells: Array<IntArray>): Int {
        var left = 1
        var right = row * col
        
        while (left < right) {
            val mid = right - (right - left) / 2
            if (canCross(row, col, cells, mid)) {
                left = mid
            } else {
                right = mid - 1
            }
        }
        return left
    }

    private fun canCross(row: Int, col: Int, cells: Array<IntArray>, day: Int): Boolean {
        val grid = Array(row) { IntArray(col) }
        for (i in 0 until day) {
            val r = cells[i][0] - 1
            val c = cells[i][1] - 1
            grid[r][c] = 1
        }

        for (i in 0 until day) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1
        }

        for (i in 0 until col) {
            if (grid[0][i] == 0 && dfs(grid, 0, i, row, col)) {
                return true
            }
        }
        return false
    }

    private fun isInBoundary(grid: Array<IntArray>, r: Int, c: Int, row: Int, col: Int): Boolean {
        if (0 <= r && r < row && 0 <= c && c < col && grid[r][c] == 0) return true
        return false
    }

    private fun dfs(grid: Array<IntArray>, r: Int, c: Int, row: Int, col: Int): Boolean {
        if (!isInBoundary(grid, r, c, row, col)) return false
        if (r == row - 1) return true

        grid[r][c] = -1
        for (dir in directions) {
            val newR = r + dir[0]
            val newC = c + dir[1]
            if (dfs(grid, newR, newC, row, col))  return true
        }

        return false
    }
}
