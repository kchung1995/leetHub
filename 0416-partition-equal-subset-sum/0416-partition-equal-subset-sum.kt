class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()

        return if (sum % 2 == 1) false
        else isPartitioned(nums, sum / 2)
    }

    private fun isPartitioned(nums: IntArray, subsetSum: Int): Boolean {
        val n = nums.size
        val dp = Array(n + 1) { BooleanArray(subsetSum + 1) { false } }
        dp[0][0] = true

        for (i in 1 .. n) {
            val num = nums[i - 1]
            for (j in 0 .. subsetSum) {
                if (j < num) dp[i][j] = dp[i - 1][j]
                else dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num]
            }
        }

        return dp[n][subsetSum]
    }
}

