class Solution {
    fun paintWalls(cost: IntArray, time: IntArray): Int {
        val n = cost.size
        val dp = Array(n + 1) { IntArray(n + 1) { 0 } }

        for (i in 1..n) {
            dp[n][i] = 1000000000
        }

        for (i in n - 1 downTo 0) {
            for (leftover in 1..n) {
                val paint = cost[i] + dp[i + 1][maxOf(0, leftover - 1 - time[i])]
                val paintNot = dp[i + 1][leftover]
                dp[i][leftover] = minOf(paint, paintNot)
            }
        }

        return dp[0][n]
    }
}

