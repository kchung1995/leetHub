class Solution {
    fun maxProfit(prices: IntArray): Int {
        val n = prices.size
        var currentMax: Int = prices[n - 1]
        var result: Int = 0

        for (i in n - 1 downTo 0) {
            currentMax = maxOf(currentMax, prices[i])
            result = maxOf(result, currentMax - prices[i])
        }

        return result
    }
}
