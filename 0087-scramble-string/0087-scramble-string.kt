class Solution {
    fun isScramble(s1: String, s2: String): Boolean {
        val n = s1.length
        when {
            n != s2.length -> return false
            s1 == s2 -> return true
        }

        val dp = Array(n) { Array(n) { BooleanArray(n + 1) } }

        for (i in 0 until n) {
            for (j in 0 until n) {
                dp[i][j][1] = s1[i] == s2[j]
            }
        }

        for (len in 2..n) {
            for (i in 0..n - len) {
                for (j in 0..n - len) {
                    for (k in 1 until len) {
                        if ((dp[i][j][k] && dp[i + k][j + k][len - k]) ||
                            (dp[i][j + len - k][k] && dp[i + k][j][len - k])) {
                            dp[i][j][len] = true
                            break
                        }
                    }
                }
            }
        }

        return dp[0][0][n]
    }
}
