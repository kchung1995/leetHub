class Solution {
    fun longestPalindromeSubseq(s: String): Int {
        val n = s.length
        val dp = Array(n) { IntArray(n) }

        for (i in 0 until n) {
            dp[i][i] = 1
        }

        for (length in 2..n) {
            for (i in 0 until (n - length + 1)) {
                val j = i + length - 1
                
                if (s[i] == s[j]) dp[i][j] = dp[i + 1][j - 1] + 2
                else dp[i][j] = maxOf(dp[i + 1][j], dp[i][j - 1])
            }
        }

        return dp[0][n - 1]
    }
}

