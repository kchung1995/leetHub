class Solution {
    fun profitableSchemes(n: Int, minProfit: Int, group: IntArray, profit: IntArray): Int {
        val MOD = 1000000007
        val dp = Array(n + 1) { IntArray(minProfit + 1) }
        dp[0][0] = 1

        for (i in group.indices) {
            val currentGroup = group[i]
            val currentProfit = profit[i]

            for (j in n downTo currentGroup) {
                for (k in minProfit downTo 0) {
                    dp[j][k] = (dp[j][k] + dp[j - currentGroup][maxOf(0, k - currentProfit)]) % MOD
                }
            }
        }
        var result: Int = 0
        for (i in 0..n) {
            result = (result + dp[i][minProfit]) % MOD
        }
        return result
    }
}

