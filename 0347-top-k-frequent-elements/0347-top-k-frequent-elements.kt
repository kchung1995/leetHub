data class ElementCount(val element: Int, val count: Int)

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val numsCount = mutableMapOf<Int, Int>()
        for (i in nums) {
            val currentValue = numsCount[i]
            when (currentValue) {
                null -> numsCount[i] = 1
                else -> numsCount[i] = currentValue + 1
            }
        }

        val elementCount: List<ElementCount> = numsCount.map {
            ElementCount(it.key, it.value)
        }.sortedByDescending { it.count }

        val result = IntArray(k) { elementCount[it].element }
        return result
    }
}

