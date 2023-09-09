class Solution {
    fun minSideJumps(obstacles: IntArray): Int {
        val kInf = 1000000

        val dp = intArrayOf(kInf, 1, 0, 1)

        for (obstacle in obstacles) {
            if (obstacle > 0)
                dp[obstacle] = kInf
            for (i in 1..3) {
                if (i != obstacle) {
                    for (j in 1..3) {
                        dp[i] = minOf(dp[i], dp[j] + if (i == j) 0 else 1)
                    }
                }
            }
        }

        return dp.minOrNull()!!
    }
}

