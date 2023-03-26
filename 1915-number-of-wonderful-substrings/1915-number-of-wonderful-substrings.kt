class Solution {
    fun wonderfulSubstrings(word: String): Long {
        var result: Long = 0
        val frequencyCount = HashMap<Int, Long>()
        var bitmask = 0
        
        frequencyCount[0] = 1
        
        for (ch in word) {
            val character = ch - 'a'
            bitmask = bitmask xor (1 shl character)
            result += frequencyCount.getOrDefault(bitmask, 0)
            
            for (j in 0 until 10) {
                val next = bitmask xor (1 shl j)
                result += frequencyCount.getOrDefault(next, 0)
            }
            frequencyCount[bitmask] = frequencyCount.getOrDefault(bitmask, 0) + 1
        }
        
        return result
    }
}
