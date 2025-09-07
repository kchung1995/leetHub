class Solution {
    fun findSubarrays(nums: IntArray): Boolean {
        val sumMemo = mutableSetOf<Int>()

        for (i in 1 until nums.size) {
            if (sumMemo.add(nums[i] + nums[i - 1]).not()) return true
        }

        return false
    }
}

