class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var zeroCount: Int = 0
        var result: Int = 0

        var start: Int = 0
        for (i in 0 until nums.size) {
            zeroCount += if (nums[i] == 0) 1 else 0
            while (zeroCount > 1) {
                zeroCount -= if (nums[start] == 0) 1 else 0
                start++
            }

            result = maxOf(result, i - start)
        }

        return result
    }
}

