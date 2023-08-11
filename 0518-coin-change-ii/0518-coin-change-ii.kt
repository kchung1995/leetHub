class Solution {
    fun change(amount: Int, coins: IntArray): Int {
        val n = coins.size
        val dp = Array(n + 1) { IntArray( amount + 1) { 0 } }

        for (i in 0 until n) dp[i][0] = 1
        for (i in 1..amount) dp[0][i] = 0

        for (i in n - 1 downTo 0) {
            for (j in 1..amount) {
                when (coins[i] > j) {
                    true -> dp[i][j] = dp[i + 1][j]
                    else -> dp[i][j] = dp[i + 1][j] + dp[i][j - coins[i]]
                }
            }
        }

        return dp[0][amount]
    }
}

