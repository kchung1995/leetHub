class Solution {
    private var n: Int = 0

    fun maxValueOfCoins(piles: List<List<Int>>, k: Int): Int {
        n = piles.size
        val dp = Array(n) { IntArray(k + 1) { -1 } }

        return prefixSum(0, k, piles, dp)
    }

    private fun prefixSum(i: Int, k: Int, piles: List<List<Int>>, dp: Array<IntArray>): Int {
        if (i == n || k == 0) return 0
        
        if (dp[i][k] == -1) {
            dp[i][k] = prefixSum(i + 1, k, piles, dp)
            var prefix: Int = 0
            for (j in 0 until piles[i].size) {
                if (j >= k) break
                prefix += piles[i][j]
                dp[i][k] = maxOf(dp[i][k], prefix + prefixSum(i + 1, k - j - 1, piles, dp))
            }
        }

        return dp[i][k]
    }
}

