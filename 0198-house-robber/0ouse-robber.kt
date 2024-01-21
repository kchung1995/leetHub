class Solution {
    fun rob(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) return 0

        val a = mutableListOf(0, 0)
        val b = mutableListOf(0, 0)
        b[0] = nums[0]

        for (i in 1 until n) {
            a[i % 2] = max(a[(i - 1) % 2], b[(i - 1) % 2])
            b[i % 2] = a[(i - 1) % 2] + nums[i]
        }

        return maxOf(a[(n - 1) % 2], b[(n - 1) % 2])
    }
}
