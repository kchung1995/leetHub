class Solution {
    fun putMarbles(weights: IntArray, k: Int): Long {
        val n = weights.size
        val weightsPair = IntArray(n - 1) { weights[it] + weights[it + 1] }.sorted()

        var result: Long = 0
        for (i in 0 until k - 1) {
            val temp: Long = (weightsPair[n - 2 - i] - weightsPair[i]).toLong()
            result += temp
        }

        return result
    }
}

