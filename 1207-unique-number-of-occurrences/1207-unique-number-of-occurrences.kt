class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val numberCount = HashMap<Int, Int>()
        for (number in arr) {
            numberCount[number] = numberCount.getOrDefault(number, 0) + 1
        }

        val n = numberCount.size
        val occurrences = numberCount.values.toSet()

        return occurrences.size == n
    }
}

