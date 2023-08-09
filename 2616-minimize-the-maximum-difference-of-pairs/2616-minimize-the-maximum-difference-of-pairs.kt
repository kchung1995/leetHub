class Solution {
    fun minimizeMax(nums: IntArray, p: Int): Int {
        nums.sort()
        val n = nums.size
        var left = 0
        var right = nums[n - 1] - nums[0]
        var mid: Int = -1

        while (left < right) {
            mid = left + (right - left) / 2

            if (countValidPairs(nums, mid) >= p) right = mid
            else left = mid + 1
        }
        return left
    }

    private fun countValidPairs(nums: IntArray, threshold: Int): Int {
        var index = 0
        var count = 0

        while (index < nums.size - 1) {
            if (nums[index + 1] - nums[index] <= threshold) {
                count++
                index++
            }
            index++
        }

        return count
    }
}

