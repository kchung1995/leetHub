class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val left = nums.indexOf(target)
        if (left == -1 || nums[left] != target) return intArrayOf(-1, -1)
        val right = nums.lastIndexOf(target)
        return intArrayOf(left, right)
    }
}

