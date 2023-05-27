class Solution {
    fun stoneGameIII(stoneValue: IntArray): String {
        val n = stoneValue.size
        val dp = IntArray(4)

        for (i in n - 1 downTo 0) {
            dp[i % 4] = stoneValue[i] - dp[(i + 1) % 4]
            if (i + 2 <= n)
                dp[i % 4] = maxOf(dp[i % 4], stoneValue[i] + stoneValue[i + 1] - dp[(i + 2) % 4])
            if (i + 3 <= n)
                dp[i % 4] = maxOf(dp[i % 4], stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2] - dp[(i + 3) % 4])
        }

        return when {
            dp[0] > 0 -> "Alice"
            dp[0] < 0 -> "Bob"
            else -> "Tie"
        }
    }
}

