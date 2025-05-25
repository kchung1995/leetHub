class Solution {
    private val firstLenSum = HashMap<Int, Int>()
    private val secondLenSum = HashMap<Int, Int>()

    fun maxSumTwoNoOverlap(nums: IntArray, firstLen: Int, secondLen: Int): Int {
        calculateSums(firstLen, nums, firstLenSum)
        calculateSums(secondLen, nums, secondLenSum)

        return maxOf(
            slidingWindow(firstLen, secondLen, nums, firstLenSum, secondLenSum),
            slidingWindow(secondLen, firstLen, nums, secondLenSum, firstLenSum)
        )
    }

    private fun calculateSums(length: Int, nums: IntArray, sumMap: HashMap<Int, Int>) {
        // initialise
        var currentSum: Int = 0
        for (start in 0 until nums.size) {
            for (current in start until start + length) {
                if (current >= nums.size) {
                    currentSum = -1
                    break
                }
                currentSum += nums[current]
            }
            if (currentSum == -1) break
            sumMap[start] = currentSum
            currentSum = 0
        }
    }

    private fun slidingWindow(firstLen: Int, secondLen: Int, nums: IntArray, firstMap: HashMap<Int, Int>, secondMap: HashMap<Int, Int>): Int {
        var currentMaxSum: Int = 0

        // var centreIndex: Int = secondLen
        for (centre in 0 until nums.size) {
            if (centre + firstLen > nums.size) break

            var leftAndRightMax: Int = 0
            for (left in 0 .. centre - secondLen) {
                leftAndRightMax = maxOf(leftAndRightMax, secondMap[left]!!)
            }
            for (right in firstLen + centre .. nums.size) {
                if (right + secondLen >= nums.size) break
                leftAndRightMax = maxOf(leftAndRightMax, secondMap[right]!!)
            }

            val newCurrentMaxSum = maxOf(currentMaxSum, leftAndRightMax + firstMap[centre]!!)
            if (currentMaxSum != newCurrentMaxSum) {
                currentMaxSum = maxOf(currentMaxSum, leftAndRightMax + firstMap[centre]!!)
            }
        }

        return currentMaxSum
    }
}

