class Solution {
    fun minCost(nums: IntArray, cost: IntArray): Long {
        val n = nums.size
        val numsAndCost = (0 until n).map {
            Pair(nums[it].toLong(), cost[it].toLong())
        }.sortedBy { it.first}

        val prefixCost = LongArray(n)
        prefixCost[0] = numsAndCost[0].second
        for (i in 1 until n) {
            prefixCost[i] = numsAndCost[i].second + prefixCost[i - 1]
        }

        var totalCost: Long = 0
        for (i in 1 until n) {
            totalCost += numsAndCost[i].second * (numsAndCost[i].first - numsAndCost[0].first)
        }
        var result: Long = totalCost
        for (i in 1 until n) {
            val diff = numsAndCost[i].first - numsAndCost[i - 1].first
            totalCost += prefixCost[i - 1] * diff
            totalCost -= (prefixCost[n - 1] - prefixCost[i - 1]) * diff
            result = minOf(result, totalCost)
        }

        return result
    }
}

