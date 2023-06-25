class Solution {
    fun countRoutes(locations: IntArray, start: Int, finish: Int, fuel: Int): Int {
        val DIV = 1000000007
        val n = locations.size
        val dp = Array(n) { IntArray (fuel + 1) }
        dp[finish].fill(1)

        for (j in 0..fuel) {
            for (i in 0 until n) {
                for (k in 0 until n) {
                    if (k == i) continue
                    if (Math.abs(locations[i] - locations[k]) <= j) {
                        dp[i][j] = (dp[i][j] + dp[k][j - Math.abs(locations[i] - locations[k])]) % DIV
                    }
                }
            }
        }

        return dp[start][fuel]
    }
}
