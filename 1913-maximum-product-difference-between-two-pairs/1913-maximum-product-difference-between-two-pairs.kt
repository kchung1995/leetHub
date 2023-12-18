class Solution {
    fun maxProductDifference(nums: IntArray): Int {
        val n = nums.size
        nums.sort()

        return (nums[n - 1] * nums[n - 2]) - nums[0] * nums[1]
    }
}

