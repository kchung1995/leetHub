class Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        val n = nums.size
        nums.sort()
        var substituteTo: Int = -1
        var appear: Int = 1

        for (i in 1 until n) {
            if (nums[i] == nums[i - 1])
                substituteTo = nums[i];
            else if (nums[i] > nums[i - 1] + 1)
                appear = nums[i - 1] + 1;
        }

        return intArrayOf(substituteTo, if (nums[n - 1] != n) n else appear)
    }
}

