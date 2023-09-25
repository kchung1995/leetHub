class Solution {
    fun findTheDifference(s: String, t: String): Char {
        val charCount = IntArray(26) { 0 }
        for (i in s) {
            charCount[(i - 'a').toInt()]++
        }
        for (i in t) {
            charCount[(i - 'a').toInt()]--
            if (charCount[(i - 'a').toInt()] < 0) return i
        }
        return 'A'
    }
}

