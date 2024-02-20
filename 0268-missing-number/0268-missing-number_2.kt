class Solution {
    fun missingNumber(nums: IntArray): Int {
        nums.sort()
        val n = nums.size
        var left: Int = 0
        var right: Int = nums.size

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (isMissingNumber(mid, nums, n)) return mid
            if (nums[mid] == mid) left = mid + 1
            else right = mid
        }

        return -1
    }

    private fun isMissingNumber(current: Int, nums: IntArray, n: Int): Boolean {
        if (current == 0) {
            return if (nums[current] == 1) true
            else false
        }
        if (current == n) {
            return if (current - 1 == nums[current - 1]) true
            else false
        }
        if (current != nums[current] && current - 1 == nums[current - 1]) return true
        return false
    }
}

