class Solution {
    private val MOD: Long = 1000000000 + 7
    private val m = 1001

    fun countOfPairs(nums: IntArray): Int {
        val n = nums.size
        var dp = LongArray(m) { 1 }

        for (i in 1 until n) {
            val d = maxOf(0, nums[i] - nums[i - 1])
            val dpSub = LongArray(m)
            for (j in d until nums[i] + 1) {
                dpSub[j] = ((if (j > 0) dpSub[j - 1] else 0) + dp[j - d]) % MOD
            }
            dp = dpSub
        }

        var result: Long = 0
        (0 .. nums[n - 1]).forEach { result = (result + dp[it]) % MOD }
        return result.toInt()
    }
}

