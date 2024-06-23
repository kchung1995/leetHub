class Solution {
    fun maxProfit(prices: IntArray): Int {
        val n = prices.size
        val profits = IntArray(n + 2)

        for (i in n - 1 downTo 0) {
            val chanceOne = (i + 1 .. n - 1).map { sell -> prices[sell] - prices[i] + profits[sell + 2] }
                .maxOrNull() ?: 0
            val chanceTwo = profits[i + 1]
            profits[i] = maxOf(chanceOne, chanceTwo)
        }

        return profits[0]
    }
}

