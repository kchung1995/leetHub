import kotlin.math.ceil

class Solution {
    fun soupServings(n: Int): Double {
        val m = ceil(n / 25.0).toInt()
        val dp = mutableMapOf<Int, MutableMap<Int, Double>>()

        for (k in 1..m) {
            if (calculateDP(k, k, dp) > 1 - 1e-5) {
                return 1.0
            }
        }
        return calculateDP(m, m, dp)
    }

    private fun calculateDP(i: Int, j: Int, dp: MutableMap<Int, MutableMap<Int, Double>>): Double {
        when {
            (i <= 0 && j <= 0) -> return 0.5
            (i <= 0) -> return 1.0
            (j <= 0) -> return 0.0
            (dp.containsKey(i) && dp[i]?.containsKey(j) == true) -> return dp[i]!![j]!!
        }

        val result = (calculateDP(i - 4, j, dp) + calculateDP(i - 3, j - 1, dp) +
                calculateDP(i - 2, j - 2, dp) + calculateDP(i - 1, j - 3, dp)) / 4.0
        dp.getOrPut(i) { mutableMapOf() }[j] = result
        return result
    }
}

