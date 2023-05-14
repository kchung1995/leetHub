class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val n = nums.size
        val sub = mutableListOf<Int>()

        sub.add(nums[0])
        for (i in 0 until n) {
            if (sub[sub.size - 1] < nums[i]) sub.add(nums[i])
            else {
                val j = binarySearch(sub, nums[i])
                sub[j] = nums[i]
            }
        }

        return sub.size
    }

    private fun binarySearch(nums: List<Int>, target: Int): Int {
        var left: Int = 0
        var right: Int = nums.size - 1

        while (left < right) {
            val mid = left + ((right - left) / 2)
            when {
                nums[mid] == target -> return mid
                nums[mid] < target ->  left = mid + 1
                else -> right = mid
            }
        }
        return left
    }
}

