class Solution {
    fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
        val n = jobDifficulty.size
        val dp = Array(n) { IntArray(d + 1) { -1 } }

        if (n < d) return -1

        return memoization(i = 0, daysRemaining = d, jobDifficulty, dp)
    }

    private fun memoization(i: Int, daysRemaining: Int, jobDifficulty: IntArray, dp: Array<IntArray>): Int {
        val n = jobDifficulty.size
        if (dp[i][daysRemaining] != -1) return dp[i][daysRemaining]

        if (daysRemaining == 1) {
            var result: Int = 0
            for (j in i until n) {
                result = maxOf(result, jobDifficulty[j])
            }
            return result
        }

        var result: Int = Integer.MAX_VALUE
        var dailyMaxJobDifference: Int = 0

        for (j in i until n - daysRemaining + 1) {
            dailyMaxJobDifference = maxOf(dailyMaxJobDifference, jobDifficulty[j])
            val newMinimumDifference = memoization(j + 1, daysRemaining - 1, jobDifficulty, dp)
            result = minOf(result, dailyMaxJobDifference + newMinimumDifference)
        }
        
        dp[i][daysRemaining] = result
        return result
    }
}

