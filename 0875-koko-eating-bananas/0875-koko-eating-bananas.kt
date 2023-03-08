class Solution {
    fun getRounding(banana: Int, k: Int): Int = 
        when (banana % k) {
            0 -> (banana / k)
            else -> (banana / k) + 1
        }
    
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        piles.sort()
        var left: Int = 1
        var right: Int = piles[piles.size - 1]
        
        while (left < right) {
            val k = left + ((right - left) / 2)
            
            var sum: Int = 0
            for (i in piles) {
                sum += getRounding(i, k)
                if (sum > h) {
                    left = k + 1
                    continue
                }
            }
            
            when (sum > h) {
                true -> left = k + 1
                else -> right = k
            }
        }
        
        return left
    }
}