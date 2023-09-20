class Solution {
    fun minOperations(nums: IntArray, x: Int): Int {
        val n = nums.size
        val subSums = IntArray(n + 1) { 0 }
        for (i in 1..n) {
            subSums[i] = nums[i - 1] + subSums[i - 1]
        }

        val mediumSums = subSums[n] - x
        var answer = 1e9.toInt()
        var left = 0

        for (right in 1..n) {
            while (left < right && subSums[right] - subSums[left] > mediumSums) {
                left++
            }

            if (subSums[right] - subSums[left] == mediumSums) {
                answer = minOf(answer, n - (right - left))
            }
        }

        return if (answer == 1e9.toInt()) -1 else answer
    }
}

