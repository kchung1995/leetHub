class Solution {
    fun majorityElement(nums: IntArray): List<Int> {
        val result = mutableListOf<Int>()
        nums.sort()
        val n = nums.size / 3
        var prevValue: Int = Integer.MIN_VALUE
        for (i in 0 until nums.size) {
            if (nums[i] != prevValue) {
                prevValue = nums[i]
                if (i + n < nums.size && nums[i + n] == nums[i]) result.add(nums[i])
            }
        }

        return result
    }
}
