class Solution {
    fun maxFrequency(nums: IntArray, k: Int): Int {
        val n = nums.size
        nums.sort()
        var left: Int = 0
        var current: Int = 0

        for (right in 0 until n) {
            val target = nums[right]
            current += target

            if ((right - left + 1) * target - current > k) {
                current -= nums[left]
                left++
            }
        }

        return n - left
    }
}

