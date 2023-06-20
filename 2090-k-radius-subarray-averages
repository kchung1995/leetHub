class Solution {
    fun getAverages(nums: IntArray, k: Int): IntArray {
        if (k == 0) return nums

        val n = nums.size
        val div = 2 * k + 1
        val result = IntArray(n) { -1 }

        if (div > n) return result

        var current: Long = 0
        for (i in 0 until div) current += nums[i]
        result[k] = (current / div).toInt()

        for (i in div until n) {
            current = current - nums[i - div] + nums[i]
            result[i - k] = (current / div).toInt()
        }

        return result
    }
}
