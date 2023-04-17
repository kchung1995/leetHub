class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val maxCandies = requireNotNull(candies.max())
        val result = MutableList<Boolean>(candies.size) { false }
        
        for (i in candies.indices) {
            val current = candies[i] + extraCandies
            if (current >= maxCandies) {
                result[i] = true
            }
        }
        
        return result
    }
}

