class Solution {
    fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
        val dp = Array(high + 1) { 0 }
        val mod = 1000000007

        val min = minOf(zero, one)
        dp[0] = 1

        for (i in min..high) {
            if (i >= zero) dp[i] = (dp[i] + dp[i - zero]) % mod
            if (i >= one) dp[i] = (dp[i] + dp[i - one]) % mod
        }

        var result: Int = 0
        for (i in low..high) {
            result = (result + dp[i]) % mod
        }
        return result
    }
}

