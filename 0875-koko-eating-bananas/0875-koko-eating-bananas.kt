class Solution {
    fun getRounding(bananas: Int, k: Int): Int = 
        when (bananas % k) {
            0 -> (bananas / k)
            else -> (bananas / k) + 1
        }
    
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        piles.sort()
        var left: Int = 1
        var right: Int = piles[piles.size - 1]
        
        while (left < right) {
            val k = left + ((right - left) / 2)
            val sum = piles.map { getRounding(it, k) }.sum()
            
            when (sum > h) {
                true -> left = k + 1
                else -> right = k
            }
        }
        
        return left
    }
}