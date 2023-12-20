class Solution {
    fun buyChoco(prices: IntArray, money: Int): Int {
        prices.sort()

        val minCost = prices[0] + prices[1]
        return when {
            minCost <= money -> money - minCost
            else -> money
        }
    }
}

