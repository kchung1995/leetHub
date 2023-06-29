class Solution {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size
        val dp = Array(m) { mIndex -> IntArray(n) { nIndex -> mat[mIndex][nIndex] } }

        for (row in 0 until m) {
            for (column in 0 until n) {
                if (dp[row][column] == 0) continue

                var minNeighbour = m * n
                if (row > 0) minNeighbour = minOf(minNeighbour, dp[row - 1][column])
                if (column > 0) minNeighbour = minOf(minNeighbour, dp[row][column - 1])
                dp[row][column] = minNeighbour + 1
            }
        }

        for (row in m - 1 downTo 0) {
            for (column in n - 1 downTo 0) {
                if (dp[row][column] == 0) continue

                var minNeighbour = m * n
                if (row < m - 1) minNeighbour = minOf(minNeighbour, dp[row + 1][column])
                if (column < n - 1) minNeighbour = minOf(minNeighbour, dp[row][column + 1])
                dp[row][column] = minOf(dp[row][column], minNeighbour + 1)
            }
        }

        return dp
    }
}
