class Solution {
    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        val n = nums.size
        val frequencyCount = HashMap<Int, Int>()

        var left: Int = 0
        var overCountedCharsCount: Int = 0

        for (right in 0 until n) {
            val value = frequencyCount.getOrDefault(nums[right], 0) + 1
            frequencyCount[nums[right]] = value

            if (frequencyCount[nums[right]] == k + 1) overCountedCharsCount++
            if (overCountedCharsCount > 0) {
                frequencyCount[nums[left]] = frequencyCount[nums[left]]!! - 1
                if (frequencyCount[nums[left]] == k) overCountedCharsCount--
                left++
            }
        }

        return (n - left)
    }
}

