class Solution {
    fun isMonotonic(nums: IntArray): Boolean {
        val n = nums.size - 1
        if (nums[0] == nums[n]) {
            nums.sort()
            return if (nums[0] == nums[n]) true else false
        }
        val isIncreasing = isIncreasing(nums[0], nums[n])

        for (i in 0 until n) {
            if (isEqual(nums[i], nums[i + 1])) continue
            if (isIncreasing(nums[i], nums[i + 1]) != isIncreasing) return false
        }

        return true
    }

    private fun isIncreasing(first: Int, second: Int): Boolean = first < second

    private fun isEqual(first: Int, second: Int): Boolean = first == second
}
