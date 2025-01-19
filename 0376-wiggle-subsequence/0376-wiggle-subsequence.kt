class Solution {
    fun wiggleMaxLength(nums: IntArray): Int {
        val n = nums.size

        if (n < 2) return n
        val up = IntArray(n)
        val down = IntArray(n)
        up[0] = 1
        down[0] = 1

        for (i in 1 until n) {
            when {
                nums[i] > nums[i - 1] -> {
                    up[i] = down[i - 1] + 1
                    down[i] = down[i - 1]
                }
                nums[i] < nums[i - 1] -> {
                    down[i] = up[i - 1] + 1
                    up[i] = up[i - 1]
                }
                else -> {
                    down[i] = down[i - 1]
                    up[i] = up[i - 1]
                }
            }
        }

        return maxOf(down[n - 1], up[n - 1])
    }
}

