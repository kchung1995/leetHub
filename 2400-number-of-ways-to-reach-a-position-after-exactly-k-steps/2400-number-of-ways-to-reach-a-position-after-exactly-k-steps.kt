class Solution {
    val MOD = 1000000007

    fun numberOfWays(startPos: Int, endPos: Int, k: Int): Int {
        val value = k + endPos - startPos
        if (value < 0 || value % 2 == 1) return 0

        val rightStep = value / 2
        val leftStep = k - rightStep

        if (leftStep < 0) return 0
        return nCk(steps = leftStep + rightStep, minStep = minOf(leftStep, rightStep))
    }

    private fun nCk(steps: Int, minStep: Int): Int {
        val dp = IntArray(minStep + 1)
        dp[0] = 1

        var count: Int = steps
        while (count-- > 0) {
            for (j in minStep downTo 1) {
                dp[j] += dp[j - 1]
                dp[j] %= MOD
            }
        }
        return dp[minStep]
    }
}

