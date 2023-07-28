class Solution {
    fun PredictTheWinner(nums: IntArray): Boolean {
        val n = nums.size
        val dp = nums.copyOf()

        for (diff in 1 until n) {
            for (left in 0 until n - diff) {
                val right = left + diff
                dp[left] = maxOf(nums[left] - dp[left + 1], nums[right] - dp[left])
            }
        }

        return dp[0] >= 0
    }
}

