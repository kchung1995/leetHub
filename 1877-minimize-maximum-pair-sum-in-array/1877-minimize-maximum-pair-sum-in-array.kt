class Solution {
    fun minPairSum(nums: IntArray): Int {
        val n = nums.size
        nums.sort()
        var result: Int = 0
        
        for (i in 0 until n / 2) {
            result = maxOf(result, nums[i] + nums[n - i - 1])
        }

        return result
    }
}

