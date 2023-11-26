class Solution {
    fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
        val n = nums.size
        val prefix = IntArray(n) { 0 }
        prefix[0] = nums[0]
        for (i in 1 until n) {
            prefix[i] = prefix[i - 1] + nums[i]
        }

        val result = IntArray(n)
        for (i in 0 until n) {
            val leftSum = prefix[i] - nums[i]
            val rightSum = prefix[n - 1] - prefix[i]

            val leftCount = i
            val rightCount = n - i - 1

            val leftTotal = leftCount * nums[i] - leftSum
            val rightTotal = rightSum - (rightCount * nums[i])

            result[i] = leftTotal + rightTotal
        }

        return result
    }
}

