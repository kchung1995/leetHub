class Solution {
    fun maxProfit(prices: IntArray): Int {
        var result: Int = 0
        var currentPurchaseCost: Int = prices[0]
        
        for (i in 0 until prices.size) {
            if (currentPurchaseCost > prices[i]) {
                currentPurchaseCost = prices[i]
            }
            else {
                result = maxOf(result, prices[i] - currentPurchaseCost)
            }
        }
        
        return result
    }
}