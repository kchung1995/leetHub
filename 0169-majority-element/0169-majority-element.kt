class Solution {
    fun majorityElement(nums: IntArray): Int {
        nums.sort()
        val n = nums.size
        return nums[n / 2]
    }
}
