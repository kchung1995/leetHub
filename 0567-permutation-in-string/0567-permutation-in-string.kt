class Solution {
    fun initializeHashMap(): HashMap<Char, Int> {
        val result = HashMap<Char, Int>()
        for (i in 'a'..'z') {
            result.put(i, 0)
        }
        return result
    }
    
    fun isEqualHashMap(s1: HashMap<Char, Int>, s2: HashMap<Char, Int>): Boolean {
        for (i in 'a'..'z') {
            if (s1[i] != s2[i])
                return false
        }
        return true
    }
    
    fun checkInclusion(s1: String, s2: String): Boolean {
        // s1's length should be greater than s2's.
        // first, check each char's frequency of s1.
        // then, check each char's frequency of s2's substing, length of s1.
        // continue exploring until the end
        
        if (s1.length > s2.length)
            return false
        
        val s1Chars = initializeHashMap()
        val s2Chars = initializeHashMap()
        
        for (i in s1)
            s1Chars[i] = s1Chars[i]!! + 1
        for (i in 0 until s1.length) {
            val curr = s2[i]
            s2Chars[curr] = s2Chars[curr]!! + 1
        }
        if (isEqualHashMap(s1Chars, s2Chars))
            return true
        
        for (i in 0 until s2.length - s1.length) {
            val remove: Char = s2[i]
            val add: Char = s2[i + s1.length]
            
            s2Chars[remove] = s2Chars[remove]!! - 1
            s2Chars[add] = s2Chars[add]!! + 1
                
            if (isEqualHashMap(s1Chars, s2Chars))
                return true
                
        }
        
        return false
    }
}
