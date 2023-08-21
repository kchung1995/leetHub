class Solution {
    fun repeatedSubstringPattern(s: String): Boolean {
        val n = s.length

        for (i in n / 2 downTo 1) {
            if (n % i != 0) continue
            if (isAllMatching(s, i)) return true
        }

        return false
    }

    private fun isAllMatching(s: String, m: Int): Boolean {
        val current = s.substring(0, m)
        val n = s.length

        for (i in 0 until n step m) {
            if (s.substring(i, i + m) != current) return false
        }

        return true
    }
}

