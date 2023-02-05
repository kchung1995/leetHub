class Solution {
    fun isAnagram(s: IntArray, p: IntArray): Boolean {
        for (i in 0 until s.size) {
            if (s[i] != p[i])
            return false
        }
        return true
    }
    
    fun findAnagrams(s: String, p: String): List<Int> {
        
        // first, count each alphabet in p
        // in s, count each alphabet in substring of s, length equals to length of p
        // if matches, add to result
        
        val result = mutableListOf<Int>()
        val pCount = IntArray(26)
        val sCount = IntArray(26)
           
        // cannot include a single anagram if s.length < p.length
        if (s.length < p.length) return result
        
        // comparison target p
        for (i in p) {
            pCount[i - 'a']++
        }
        
        // setup initial condition for sliding window through s
        for (i in 0 until p.length) {
            sCount[s[i] - 'a']++
        }
        
        if (isAnagram(sCount, pCount)) {
            result.add(0)
        }
        
        // continue seaching through sliding window
        for (i in 0 until s.length - p.length) {
            sCount[s[i] - 'a']--
            sCount[s[i + p.length] - 'a']++
            
            if (isAnagram(sCount, pCount)) {
                result.add(i + 1)
            }
        }
        
        return result
    }
}