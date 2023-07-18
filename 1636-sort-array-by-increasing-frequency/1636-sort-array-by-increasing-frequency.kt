class Solution {
    fun frequencySort(nums: IntArray): IntArray {
        val numbersCount = HashMap<Int, Int>()

        for (i in nums) {
            if (numbersCount.containsKey(i)) numbersCount[i] = numbersCount[i]!! + 1
            else numbersCount.put(i, 1)
        }

        val countedList = numbersCount.toList()
            .sortedWith(
                compareBy<Pair<Int, Int>> { it.second }
                .thenByDescending { it.first }
            )

        val result = mutableListOf<Int>()
        countedList.forEach { for (i in 0 until it.second) result.add(it.first) }
        return result.toIntArray()
    }
}

