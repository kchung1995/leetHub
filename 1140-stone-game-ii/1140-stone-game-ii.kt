class Solution {
    fun stoneGameII(piles: IntArray): Int {
        val n = piles.size
        val dp = Array(2) { Array(n + 1) { IntArray(n + 1) { -1 } } }

        return recursive(piles, dp, 0, 0, 1, n)
    }

    private fun recursive(piles: IntArray, dp: Array<Array<IntArray>>, p: Int, i: Int, m: Int, n: Int): Int {
        if (i == n) return 0
        if (dp[p][i][m] != -1) return dp[p][i][m]

        var result: Int = if (p == 1) 1000000 else -1
        var sum: Int = 0

        for (x in 1..minOf(2 * m, n - i)) {
            sum += piles[i + x - 1]
            if (p == 0) result = maxOf(result, sum + recursive(piles, dp, 1, i + x, maxOf(m, x), n))
            else result = minOf(result, recursive(piles, dp, 0, i + x, maxOf(m, x), n))
        }

        dp[p][i][m] = result
        return dp[p][i][m]
    }
}

