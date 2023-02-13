class Solution {
    fun parametersOdd(low: Int, high: Int): Int {
        if (low % 2 == 1 && high % 2 == 1) return -1
        if (low % 2 == 0 && high % 2 == 0) return 1
        return 0
    }
    
    fun countOdds(low: Int, high: Int): Int {
        when (parametersOdd(low, high)) {
            -1 -> return ((high - low) / 2) + 1
            1 -> return (high - low) / 2
            else -> return (high - low) / 2 + 1
        }
    }
}