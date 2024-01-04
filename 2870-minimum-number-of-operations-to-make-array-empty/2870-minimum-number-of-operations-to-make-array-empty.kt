class Solution {
    fun minOperations(nums: IntArray): Int {
        val elementsCount = HashMap<Int, Int>()
        for (num in nums) {
            elementsCount[num] = elementsCount.getOrDefault(num, 0) + 1
        }

        var result: Int = 0
        elementsCount.forEach { element ->
            if (element.value == 1) return -1
            val quotient = element.value / 3
            val remainder = element.value % 3

            if (remainder == 0) result += quotient
            else result += (quotient + 1)
        }

        return result
    }
}

