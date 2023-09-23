class Solution {
    fun longestStrChain(words: Array<String>): Int {
        var result = 0
        val dp = mutableMapOf<String, Int>()

        words.sortedBy { it.length }.forEach { word ->
            for (i in 0 until word.length) {
                val pred = word.substring(0, i) + word.substring(i + 1)
                dp[word] = maxOf(dp[word] ?: 0, (dp[pred] ?: 0) + 1)
            }
            result = maxOf(result, dp[word] ?: 0)
        }

        return result
    }
}

