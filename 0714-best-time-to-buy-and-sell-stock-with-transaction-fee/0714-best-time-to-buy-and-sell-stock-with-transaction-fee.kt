class Solution {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        val n = prices.size
        var cost: Int = 0
        var holding: Int = -prices[0]

        for (i in 0 until n) {
            val temp = holding
            holding = maxOf(holding, cost - prices[i])
            cost = maxOf(cost, temp + prices[i] - fee)
        }

        return cost
    }
}
