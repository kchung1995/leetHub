class Solution {
    fun numberOfWays(startPos: Int, endPos: Int, k: Int): Int {
        val posDiff = endPos - startPos + k
        if (posDiff < 0 || posDiff % 2 == 1) return 0

        val rightStep = posDiff / 2
        val leftStep = k - rightStep
        if (leftStep < 0) return 0

        return nCk(leftStep + rightStep, minOf(leftStep, rightStep))
    }

    private fun nCk(n: Int, k: Int): Int {
        val MOD = 1000000007
        val dp = IntArray(k + 1) { 0 }
        dp[0] = 1

        var count: Int = n
        while(count > 0) {
            for (j in k downTo 1) {
                dp[j] += dp[j - 1]
                dp[j] %= MOD
            }
            count --
        }

        return dp[k]
    }
}

