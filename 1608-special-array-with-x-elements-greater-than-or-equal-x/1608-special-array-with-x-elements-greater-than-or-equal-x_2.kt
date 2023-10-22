class Solution {
    fun specialArray(nums: IntArray): Int {
        nums.sort()
        val n = nums.size
        if (nums[0] >= n) return n

        for (i in 1 until n) {
            val count = n - i
            if (nums[i - 1] < count && nums[i] >= count) return count
        }

        return -1
    }
}

