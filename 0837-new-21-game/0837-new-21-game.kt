class Solution {
    fun new21Game(n: Int, k: Int, maxPts: Int): Double {
        val dp = DoubleArray(n + 1) { 0.0 }
        dp[0] = 1.0
        var s = if (k > 0) 1.0 else 0.0

        for (i in 1..n) {
            dp[i] = s / maxPts.toDouble()
            if (i < k) s += dp[i]
            if (i - maxPts >= 0 && i - maxPts < k) s -= dp[i - maxPts]
        }

        var result: Double = 0.0
        for (i in k..n) result += dp[i]

        return result
    }
}

