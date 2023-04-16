class Solution {
    val MOD = 1000000007
    val ALPHABETS = 26

    fun numWays(words: Array<String>, target: String): Int {
        val m = words.size
        val l = words[0].length
        val n = target.length

        val charCount = Array(l) { LongArray(ALPHABETS) }
        val dp = Array(l + 1) { IntArray(n + 1)}

        for (i in 0 until l) {
            for (j in 0 until m) {
                val charIndex = words[j][i] - 'a'
                charCount[i][charIndex]++
            }
        }

        for (i in 0 until l) {
            dp[i][0] = 1
            for (j in 0 until n) {
                if (j > i) break
                val charIndex = target[j] - 'a'
                val first = (charCount[i][charIndex] * dp[i][j]) % MOD
                val second = (first + dp[i][j + 1]) % MOD
                dp[i + 1][j + 1] = second.toInt()
            }
        }

        return dp[l][n]
    }
}
