class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { amount + 1 }
        dp[0] = 0
        
        for (i in 1..amount) {
            for (j in coins) {
                if (j <= i) dp[i] = minOf(dp[i], dp[i - j] + 1)
            }
        }
        
        return if (dp[amount] <= amount) dp[amount] else -1
    }
}