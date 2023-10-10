class Solution {
    fun minOperations(nums: IntArray): Int {
        val n = nums.size
        var result: Int = n
        val newNums = nums.sorted().distinct()

        for (i in 0 until newNums.size) {
            val left = newNums[i]
            val right = left + n - 1
            val j = newNums.upperBound(right)
            result = minOf(result, n - (j - i))
        }

        return result
    }

    private fun List<Int>.upperBound(value: Int): Int {
        var left: Int = 0
        var right: Int = this.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (this[mid] <= value) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}
