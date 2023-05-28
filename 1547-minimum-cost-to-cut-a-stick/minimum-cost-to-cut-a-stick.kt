class Solution {
    fun minCost(n: Int, cuts: IntArray): Int {
        val m = cuts.size
        val newCuts = cuts.copyOf(m + 2)
        newCuts[m + 1] = n
        newCuts.sort()
        val dp = Array(m + 2) { IntArray(m + 2) { 0 } }

        for (diff in 2 until m + 2) {
            for (left in 0 until m + 2 - diff) {
                val right = left + diff
                var result = Integer.MAX_VALUE
                for (mid in left + 1 until right) {
                    result = minOf(result, dp[left][mid] + dp[mid][right] + newCuts[right] - newCuts[left])
                }
                dp[left][right] = result
            }
        }

        return dp[0][m + 1]
    }
}

