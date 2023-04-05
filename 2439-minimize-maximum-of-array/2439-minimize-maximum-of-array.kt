class Solution {
    fun minimizeArrayValue(nums: IntArray): Int {
        var currentSum: Long = 0
        var result: Long = 0

        for (i in nums.indices) {
            currentSum += nums[i].toLong()
            val maxCandidate = (currentSum + i) / (i + 1)
            result = maxOf(result, maxCandidate)
        }

        return result.toInt()
    }
}

