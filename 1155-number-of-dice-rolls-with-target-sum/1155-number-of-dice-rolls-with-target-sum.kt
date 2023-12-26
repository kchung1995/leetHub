class Solution {
    companion object {
        val MOD: Long = 1000000007L
        val INITIALIZE_CONSTANT: Long = -1L
    }

    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
        val dp = Array(n + 1) { LongArray(target + 1 ) { INITIALIZE_CONSTANT } }
        return dfs(dp, diceIndex = 0, currentSum = 0, n, k, target).toInt()
    }

    private fun dfs(dp: Array<LongArray>, diceIndex: Int, currentSum: Int, n: Int, k: Int, target: Int): Long {
        if (diceIndex == n) return if (currentSum == target) 1 else 0
        if (dp[diceIndex][currentSum] != INITIALIZE_CONSTANT) return dp[diceIndex][currentSum]

        var result: Long = 0
        for (i in 1 .. minOf(k, target - currentSum)) {
            result = ((result + dfs(dp, diceIndex + 1, currentSum + i, n, k, target)) % MOD)
        }
        dp[diceIndex][currentSum] = result
        return dp[diceIndex][currentSum]
    }
}

