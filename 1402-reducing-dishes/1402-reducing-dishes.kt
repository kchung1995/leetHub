class Solution {
    fun maxSatisfaction(satisfaction: IntArray): Int {
        val size = satisfaction.size
        satisfaction.sortDescending()
        if (hasOnlyNegativeSatisfaction(satisfaction)) return 0

        val dp = IntArray(size + 1) { 0 }
        val likeTimeCoefficient = IntArray(size + 1) { 0 }
        dp[0] = satisfaction[0]
        likeTimeCoefficient[0] = satisfaction[0]
        for (i in 1 until size) {
            dp[i] = dp[i - 1] + satisfaction[i]
            likeTimeCoefficient[i] = likeTimeCoefficient[i - 1] + dp[i]
        }

        likeTimeCoefficient.sortDescending()
        return likeTimeCoefficient[0]
    }

    private fun hasOnlyNegativeSatisfaction(satisfaction: IntArray): Boolean = satisfaction[0] <= 0
}
