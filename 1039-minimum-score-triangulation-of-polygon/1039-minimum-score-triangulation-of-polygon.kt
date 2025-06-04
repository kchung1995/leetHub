class Solution {
    fun minScoreTriangulation(values: IntArray): Int {
        val n = values.size
        val dp = Array(n) { IntArray(n) { 0 } }

        for (j in 2 until n) {
            for (i in j - 2 downTo 0) {
                dp[i][j] = Integer.MAX_VALUE
                for (k in i + 1 until j) {
                    dp[i][j] = minOf(
                        dp[i][j],
                        dp[i][k] + dp[k][j] + triangleScore(i, j, k, values)
                    )
                }
            }
        }

        return dp[0][n - 1]
    }

    private fun triangleScore(i: Int, j: Int, k: Int, values: IntArray): Int {
        return values[i] * values[j] * values[k]
    }
}

