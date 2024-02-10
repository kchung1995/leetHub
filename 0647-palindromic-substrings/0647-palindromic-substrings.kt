class Solution {
    fun countSubstrings(str: String): Int {
        var result: Int = 0
        val n = str.length

        for (start in 0 until n) {
            for (end in start until n) {
                if (isPalindrome(str, start, end)) result++
            }
        }

        return result
    }

    private fun isPalindrome(str: String, initStart: Int, initEnd: Int): Boolean {
        var start = initStart
        var end = initEnd

        while (start < end) {
            if (str[start] != str[end]) return false
            start++
            end--
        }

        return true
    }
}

