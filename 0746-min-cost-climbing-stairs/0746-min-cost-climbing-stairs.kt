class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        val n = cost.size
        for (i in 2 until n) {
            cost[i] += minOf(cost[i - 1], cost[i - 2])
        }

        return minOf(cost[n - 1], cost[n - 2])
    }
}

