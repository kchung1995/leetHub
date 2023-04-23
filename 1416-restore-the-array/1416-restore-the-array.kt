class Solution {
    fun numberOfArrays(s: String, k: Int): Int {
        val MOD: Int = 1000000007
        val n = s.length
        val dp = IntArray(n + 1)
        dp[0] = 1

        for (i in 1..n) {
            for (j in i-1 downTo maxOf(i-9, 0)) {
                if (s[j] == '0') continue

                val num = s.substring(j, i).toLong()
                if (num > k) break
                dp[i] = (dp[i] + dp[j]) % MOD
            }
        }

        return dp[n]
    }
}

