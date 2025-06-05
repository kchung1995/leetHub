class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var leftIndex: Int = 0
        var rightIndex: Int = numbers.size - 1

        while (leftIndex < rightIndex) {
            val sum = numbers[leftIndex] + numbers[rightIndex]

            when {
                (sum == target) -> return intArrayOf(leftIndex + 1, rightIndex + 1)
                (sum < target) -> leftIndex++
                else -> rightIndex--
            }
        }

        return intArrayOf(-1, -1)
    }
}

