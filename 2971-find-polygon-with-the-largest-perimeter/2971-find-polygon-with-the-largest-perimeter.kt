class Solution {
    fun largestPerimeter(nums: IntArray): Long {
        nums.sort()

        var previousSum: Long = 0
        var result: Long = -1

        for (numInt in nums) {
            val num: Long = numInt.toLong()
            if (num < previousSum) result = num + previousSum
            previousSum += num
        }

        return result
    }
}

