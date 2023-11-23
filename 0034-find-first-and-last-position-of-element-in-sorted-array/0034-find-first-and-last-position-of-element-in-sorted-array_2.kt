class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val left = binarySearch(nums, target)
        if (left == nums.size || nums[left] != target) return IntArray(2) { -1 }
        val right = binarySearch(nums, target + 1) - 1
        return intArrayOf(left, right)
    }

    private fun binarySearch(nums: IntArray, target: Int): Int {
        var left: Int = 0
        var right: Int = nums.size

        while (left < right) {
            val mid = left + ((right - left) / 2)
            if (nums[mid] >= target) right = mid
            else left = mid + 1
        }

        return left
    }
}

