class Solution {
    fun numSquares(n: Int): Int {
        val dp = IntArray(n + 1) { Int.MAX_VALUE }
        dp[0] = 0

        val maxSquareIndex = n.squareRoot() + 1
        val squareNumbers = IntArray(maxSquareIndex) { it * it }

        for (i in 1 .. n) {
            for (s in 1 until maxSquareIndex) {
                val squareNumber = squareNumbers[s]
                if (i < squareNumber) break
                dp[i] = minOf(dp[i], dp[i - squareNumber] + 1)
            }
        }

        return dp[n]
    }

    private fun Int.squareRoot() = sqrt(this.toDouble()).toInt()
}

