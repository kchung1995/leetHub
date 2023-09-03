class Solution {
    private val MOD = 1000000007
    private val A = 0
    private val E = 1
    private val I = 2
    private val O = 3
    private val U = 4

    fun countVowelPermutation(n: Int): Int {
        val dp = Array(n + 1) { IntArray(5) }

        for (i in 0 until 5) {
            dp[1][i] = 1
        }

        for (i in 2..n) {
            dp[i][A] = mod(mod(dp[i - 1][E] + dp[i - 1][U]) + dp[i - 1][I])
            dp[i][E] = mod(dp[i - 1][A] + dp[i - 1][I])
            dp[i][I] = mod(dp[i - 1][E] + dp[i - 1][O])
            dp[i][O] = dp[i - 1][I]
            dp[i][U] = mod(dp[i - 1][O] + dp[i - 1][I])
        }

        return mod(mod(mod(dp[n][A] + dp[n][E]) + mod(dp[n][I] + dp[n][O])) + dp[n][U])
    }

    private fun mod(value: Int): Int {
        return value % MOD
    }
}

