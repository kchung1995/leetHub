class Solution {
    fun numSubseq(nums: IntArray, target: Int): Int {
        val modulo = 1000000007
        val n = nums.size
        var result = 0

        nums.sort()

        val powers = IntArray(n)
        powers[0] = 1
        for (i in 1 until n) {
            powers[i] = (powers[i - 1] * 2) % modulo
        }

        var left = 0
        var right = n - 1

        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--
            } else {
                result = (result + powers[right - left]) % modulo
                left++
            }
        }

        return result
    }
}

