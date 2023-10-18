class Solution {
    fun specialArray(nums: IntArray): Int {
        val n = nums.size
        nums.sort()

        if (nums[0] >= n) return n
        for (i in 1..n) {
            if (nums[n - i] >= i && nums[n - i - 1] < i) return i
        }

        return -1
    }
}

