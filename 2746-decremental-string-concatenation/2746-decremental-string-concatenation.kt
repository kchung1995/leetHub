import kotlin.math.min

class Solution {
    private val dp = Array(1001) { Array(27) { IntArray(27) { -1 } } }

    fun minimizeConcatenatedLength(words: Array<String>): Int {
        return words[0].length + solve(words, 1, words[0].first(), words[0].last())
    }

    private fun solve(words: Array<String>, i: Int, firstChar: Char, lastChar: Char): Int {
        if (i >= words.size) return 0
        
        val firstIndex = firstChar - 'a'
        val lastIndex = lastChar - 'a'
        
        if (dp[i][firstIndex][lastIndex] != -1) return dp[i][firstIndex][lastIndex]

        val currentWord = words[i]
        val wordSize = currentWord.length
        var result1: Int
        var result2: Int

        result1 = wordSize + solve(words, i + 1, currentWord.first(), lastChar)
        if (currentWord.last() == firstChar) result1--

        result2 = wordSize + solve(words, i + 1, firstChar, currentWord.last())
        if (currentWord.first() == lastChar) result2--

        dp[i][firstIndex][lastIndex] = min(result1, result2)
        return dp[i][firstIndex][lastIndex]
    }
}

