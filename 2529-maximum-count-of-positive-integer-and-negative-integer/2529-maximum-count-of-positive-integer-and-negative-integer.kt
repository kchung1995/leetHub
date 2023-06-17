class Solution {
    fun maximumCount(nums: IntArray): Int {
        val n = nums.size
        nums.sort()

        var result: Int = 0
        for (i in 0 until n) {
            if (nums[i] < 0) result++
            else if (nums[i] > 0) {
                result = maxOf(result, n - i)
                break
            }
        }
        return result
    }
}

