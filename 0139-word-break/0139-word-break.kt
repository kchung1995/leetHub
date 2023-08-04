class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val n = s.length
        val dp = BooleanArray(n)

        for (i in 0 until n) {
            for (word in wordDict) {
                val wordLength = word.length
                if (i < wordLength - 1) continue
                if (i == wordLength - 1 || dp[i - wordLength]) {
                    if (s.substring(i - wordLength + 1, i + 1) == word) {
                        dp[i] = true
                        break
                    }
                }
            }
        }

        return dp[n - 1]
    }
}

