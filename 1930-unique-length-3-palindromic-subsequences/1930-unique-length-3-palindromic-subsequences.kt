class Solution {
    fun countPalindromicSubsequence(s: String): Int {
        val chars = s.toSet()
        var result: Int = 0

        for (char in chars) {
            var i: Int = -1
            var j: Int = 0

            for (k in 0 until s.length) {
                if (s[k] == char) {
                    if (i == -1) i = k
                    j = k
                } 
            }

            val charsBetween = (i + 1 until j).map { s[it] }.toSet()
            result += charsBetween.size
        }

        return result
    }
}

