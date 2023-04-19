class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val n = triangle.size
        if (n == 1) return triangle[0][0]
        val dp = Array(n) { IntArray(triangle.last().size) { Integer.MAX_VALUE } }
        dp[0][0] = triangle[0][0]
        
        var result: Int = Integer.MAX_VALUE
        for (level in 0 until n - 1) {
            for (i in 0 until triangle[level].size) {
                val nextLevel = level + 1
                dp[nextLevel][i] = minOf(dp[nextLevel][i], dp[level][i] + triangle[nextLevel][i])
                dp[nextLevel][i + 1] = minOf(dp[nextLevel][i + 1], dp[level][i] + triangle[nextLevel][i + 1])
                if (level == n - 2) result = minOf(result, dp[nextLevel][i], dp[nextLevel][i + 1])
            }
        }

        return result
    }
}

