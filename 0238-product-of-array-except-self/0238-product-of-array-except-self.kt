class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val left = IntArray(n)
        val right = IntArray(n)
        val result = IntArray(n)

        left[0] = 1
        (1 until n).forEach {
            left[it] = nums[it - 1] * left[it - 1]
        }
        right[n - 1] = 1
        (n - 2 downTo 0).forEach {
            right[it] = nums[it + 1] * right[it + 1]
        }

        (0 until n).forEach { result[it] = left[it] * right[it] }

        return result
    }
}

