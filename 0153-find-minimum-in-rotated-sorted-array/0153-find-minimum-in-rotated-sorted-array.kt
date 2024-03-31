class Solution {
    fun findMin(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) return nums[0]

        var left: Int = 0
        var right: Int = n - 1

        if (nums[right] > nums[0]) return nums[0]
        while (right >= left) {
            val mid = left + ((right - left) / 2)
            when {
                nums[mid] > nums[mid + 1] -> return nums[mid + 1]
                nums[mid - 1] > nums[mid] -> return nums[mid]
            }
            if (nums[mid] > nums[0]) left = mid + 1
            else right = mid - 1
        }

        return Integer.MAX_VALUE
    }
}

