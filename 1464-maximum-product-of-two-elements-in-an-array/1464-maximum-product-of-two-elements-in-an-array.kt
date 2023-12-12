class Solution {
    fun maxProduct(nums: IntArray): Int {
        nums.sortDescending()

        return (nums[0] - 1) * (nums[1] - 1)
    }
}
