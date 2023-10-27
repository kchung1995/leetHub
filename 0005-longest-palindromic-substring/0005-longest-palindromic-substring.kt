class Solution {
    fun longestPalindrome(s: String): String {
        val n = s.length

        for (length in n downTo 1) {
            for (start in 0 .. n - length) {
                val end = start + length
                if (isPalindrome(start, end, s)) return s.substring(start, end)
            }
        }

        return ""
    }

    private fun isPalindrome(i: Int, j: Int, s: String): Boolean {
        var left: Int = i
        var right: Int = j - 1

        while (left < right) {
            if (s[left] != s[right]) return false
            left++
            right--
        }

        return true
    }
}

