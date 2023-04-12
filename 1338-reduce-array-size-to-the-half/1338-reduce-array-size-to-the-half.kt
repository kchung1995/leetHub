class Solution {
    fun minSetSize(arr: IntArray): Int {
        val compareTo: Int = arr.size / 2

        val occurrenceMap = mutableMapOf<Int, Int>()
        arr.forEach { occurrenceMap[it] = occurrenceMap.getOrDefault(it, 0) + 1 }

        val occurrenceList = occurrenceMap.values.sortedDescending()
        var result: Int = 0
        var currentCount: Int = 0

        for (i in occurrenceList) {
            currentCount += i
            result++
            if (currentCount >= compareTo) break
        }

        return result
    }
}

