class Solution {
    fun numberOfSubarrays(nums: IntArray, k: Int): Int {
        return subArray(nums, k) - subArray(nums, k - 1)
    }

    private fun subArray(nums: IntArray, k: Int): Int {
        var left: Int = 0
        var right: Int = 0
        var numberOfOdds: Int = 0
        var count: Int = 0
        val n = nums.size

        while (right < n) {
            if (nums[right] % 2 == 1) numberOfOdds++

            while (numberOfOdds > k) {
                if (nums[left] % 2 == 1) numberOfOdds--
                left++
            }

            count += (right - left + 1)
            right++
        }

        return count
    }
}

