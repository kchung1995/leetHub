class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val n = text1.length
        val m = text2.length
        val dp = Array(n + 2) { IntArray(m + 2) }

        for (j in m - 1 downTo 0) {
            for (i in n - 1 downTo 0) {
                if (text1[i] == text2[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1]
                }
                else dp[i][j] = maxOf(dp[i + 1][j], dp[i][j + 1])
            }
        }

        return dp[0][0]
    }
}

