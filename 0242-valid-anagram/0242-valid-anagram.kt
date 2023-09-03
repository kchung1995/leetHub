class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val ns = s.toCharArray().sorted()
        val nt = t.toCharArray().sorted()

        return ns == nt
    }
}


