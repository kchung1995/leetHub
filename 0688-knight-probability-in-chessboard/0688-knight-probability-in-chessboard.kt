class Solution {
    private val dx = intArrayOf(2, 2, -2, -2, 1, 1, -1, -1)
    private val dy = intArrayOf(1, -1, 1, -1, 2, -2, 2, -2)

    fun knightProbability(n: Int, k: Int, row: Int, column: Int): Double {
        val dp = Array(k + 1) { Array(n) { DoubleArray(n) } }
        dp[0][row][column] = 1.0
        
        for (move in 1..k) {
            for (i in 0 until n) {
                for (j in 0 until n) {
                    for (d in dx.indices) {
                        val ni = i + dx[d]
                        val nj = j + dy[d]
                        if (ni in 0 until n && nj in 0 until n) {
                            dp[move][i][j] += dp[move - 1][ni][nj] / 8.0
                        }
                    }
                }
            }
        }
        
        var ans: Double = 0.0
        for (i in 0 until n) {
            for (j in 0 until n) {
                ans += dp[k][i][j]
            }
        }
        
        return ans
    }
}

