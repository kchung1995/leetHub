class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var right = 0
        var sumOfCurrentWindow = 0
        var res = Int.MAX_VALUE

        while (right < nums.size) {
            sumOfCurrentWindow += nums[right]

            while (sumOfCurrentWindow >= target) {
                res = res.coerceAtMost(right - left + 1)
                sumOfCurrentWindow -= nums[left++]
            }

            right++
        }

        return if (res == Int.MAX_VALUE) 0 else res
    }
}

