class Solution {
    
    fun powerOfTwo(n: Int): Int {
        var result = 1
        for (i in 1..n) {
            result *= 2
        }
        return result
    }
    
    fun hasAllCodes(s: String, k: Int): Boolean {
        
        val sSet: HashSet<String> = HashSet()
        
        for (i in 0..s.length - k) {
            sSet.add(s.substring(i, i + k))
        }
        
        if (sSet.size < powerOfTwo(k)) {
            return false
        }
        return true
    }
}