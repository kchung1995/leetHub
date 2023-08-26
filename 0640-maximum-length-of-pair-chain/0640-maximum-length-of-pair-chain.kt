class Solution {
    fun findLongestChain(pairs: Array<IntArray>): Int {
        val n = pairs.size
        pairs.sortWith(compareBy { it[0] })
        val memo = IntArray(n)

        var result: Int = 0
        for (i in 0 until n) {
            result = maxOf(result, longestPairChain(i, pairs, n, memo))
        }
        return result
    }

        private fun longestPairChain(i: Int, pairs: Array<IntArray>, n: Int, memo: IntArray): Int {
        if (memo[i] != 0) return memo[i]
        
        memo[i] = 1
        for (j in i + 1 until n) {
            if (pairs[i][1] < pairs[j][0]) {
                memo[i] = maxOf(memo[i], 1 + longestPairChain(j, pairs, n, memo))
            }
        }
        return memo[i]
    }
}

