class Solution {
    fun minInsertions(s: String): Int {
        val n = s.length
        val dp = Array(n) { IntArray(n) }

        for (i in 2..n) {
            for (j in 0..n - i) {
                val k = i + j - 1

                when (s[j] == s[k]) {
                    true -> dp[j][k] = if (i == 2) 0 else dp[j + 1][k - 1]
                    else -> dp[j][k] = 1 + minOf(dp[j + 1][k], dp[j][k - 1])
                }
            }
        }
        return dp[0][n - 1]
    }
}

