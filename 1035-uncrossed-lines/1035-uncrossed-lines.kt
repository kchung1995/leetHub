class Solution {
    fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
        val m = nums1.size
        val n = nums2.size
        val dp = Array(m + 1) { IntArray(n + 1) }

        for (i in 0 until m) {
            for (j in 0 until n) {
                when {
                    nums1[i] == nums2[j] -> dp[i + 1][j + 1] = dp[i][j] + 1
                    else -> dp[i + 1][j + 1] = maxOf(dp[i + 1][j], dp[i][j + 1])
                }
            }
        }

        return dp[m][n]
    }
}

