class Solution {
    fun checkRecord(s: String): Boolean {
        if ("LLL" in s) return false
        if (s.count { it == 'A' } >= 2) return false
        return true
    }
}

