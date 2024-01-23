class Solution {
    fun maxLength(arr: List<String>): Int {
        val results = mutableListOf<String>()
        results.add("")
        var longestLength: Int = 0

        for (word in arr) {
            val n = results.size
            for (i in 0 until n) {
                val result = results[i]
                val newResult = result + word
                val newResultSet = newResult.map { it }.toSet()
                if (newResult.length != newResultSet.size) continue

                results.add(newResult)
                longestLength = maxOf(longestLength, newResult.length)
            }
        }

        return longestLength
    }
}

