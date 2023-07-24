class Solution {
    fun triangularSum(nums: IntArray): Int {
        return recursive(nums)
    }

    private fun recursive(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) return nums[0]
        val newNums = IntArray(n - 1)

        for (i in 0 until n - 1) {
            newNums[i] = (nums[i] + nums[i + 1]) % 10
        }

        return if (n == 2) newNums[0]
        else recursive(newNums)
    }
}

