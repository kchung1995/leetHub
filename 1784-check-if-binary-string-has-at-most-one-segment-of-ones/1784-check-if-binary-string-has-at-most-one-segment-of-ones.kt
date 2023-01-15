class Solution {
    fun checkOnesSegment(s: String): Boolean {
        if (s.length == 1) return true
        var hasFoundOneBefore: Boolean = false
        var prevValIsOne: Boolean = false
        
        for (i in 0 until s.length) {
            if (s[i] == '1') {
                if (!prevValIsOne && hasFoundOneBefore) return false
                hasFoundOneBefore = true
                prevValIsOne = true
            }
            else {
                prevValIsOne = false
            }
        }
        return true
    }
}