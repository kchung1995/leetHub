class Solution {
    fun maxEnergyBoost(energyDrinkA: IntArray, energyDrinkB: IntArray): Long {
        val n = energyDrinkA.size
        val dp = Array(n + 5) { Array<Long>(2) { 0 } }

        for (i in n - 1 downTo 0) {
            dp[i][0] = maxOf(energyDrinkB[i] + dp[i + 1][0], dp[i + 1][1])
            dp[i][1] = maxOf(energyDrinkA[i] + dp[i + 1][1], dp[i + 1][0])
        }

        return maxOf(dp[0][0], dp[0][1])
    }
}

