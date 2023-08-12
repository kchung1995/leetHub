class Solution {
    private val dx = listOf(-1, 0, 1, 0)
    private val dy = listOf(0, 1, 0, -1)

    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val m = obstacleGrid.size
        val n = obstacleGrid[0].size
        val dp = Array(m + 1) { IntArray(n + 1) { 0 } }

        dp[0][1] = 1
        for (i in 1..m) {
            for (j in 1..n) {
                if (obstacleGrid[i- 1][j- 1] == 1) continue
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }

        return dp[m][n]
    }
}

