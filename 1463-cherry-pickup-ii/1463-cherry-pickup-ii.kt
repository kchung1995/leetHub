class Solution {
    fun cherryPickup(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        val dp = Array(m) { Array(n) { IntArray(n) { -1 } } }

        return dfs(row = 0, columnOne = 0, columnTwo = n - 1, grid = grid, dp = dp)
    }

    private fun dfs(
        row: Int,
        columnOne: Int,
        columnTwo: Int,
        grid: Array<IntArray>,
        dp: Array<Array<IntArray>>
    ): Int {
        val m = grid.size
        val n = grid[0].size
        if (columnOne < 0 || columnOne >= n || columnTwo < 0 || columnTwo >= n) return 0
        if (dp[row][columnOne][columnTwo] != -1) return dp[row][columnOne][columnTwo]

        var result: Int = 0
        result += grid[row][columnOne]
        if (columnOne != columnTwo) result += grid[row][columnTwo]

        if (row != m - 1) {
            var rangeMax: Int = 0
            for (i in columnOne - 1 .. columnOne + 1) {
                for (j in columnTwo - 1 .. columnTwo + 1) {
                    rangeMax = maxOf(rangeMax, dfs(row + 1, i, j, grid, dp))
                }
            }
            result += rangeMax
        }

        dp[row][columnOne][columnTwo] = result
        return result
    }
}

