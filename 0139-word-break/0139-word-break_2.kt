class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val n = s.length
        val bank = wordDict.toHashSet()
        val dp = BooleanArray(n + 1) { false }
        dp[0] = true

        for (i in 1..n) {
            for (j in i - 1 downTo 0) {
                if (dp[j] == true) {
                    val target = s.substring(j, i)
                    if (bank.contains(target)) {
                        dp[i] = true
                        break
                    }
                }
            }
        }

        return dp[n]
    }
}

