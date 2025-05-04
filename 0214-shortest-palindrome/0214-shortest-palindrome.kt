class Solution {
    fun shortestPalindrome(s: String): String {
        if (s.length < 2) return s

        var best = makePalindromeOdd(0, s)
        var bestLength = best.length

        val maxOddCenter = (s.length - 1) / 2
        for (i in 0..maxOddCenter) {
            if (isPalindromePrefixOdd(i, s)) {
                val cand = makePalindromeOdd(i, s)
                if (cand.length < bestLength) {
                    best = cand
                    bestLength = cand.length
                }
            }
        }

        val maxEvenCenter = (s.length / 2) - 1
        for (i in 0..maxEvenCenter) {
            if (isPalindromePrefixEven(i, s)) {
                val cand = makePalindromeEven(i, s)
                if (cand.length < bestLength) {
                    best = cand
                    bestLength = cand.length
                }
            }
        }

        return best
    }

    private fun isPalindromePrefixOdd(idx: Int, s: String): Boolean {
        var left = idx
        var right = idx

        while (left >= 0 && right < s.length) {
            if (s[left] != s[right]) return false
            left--
            right++
        }
        return true
    }

    private fun makePalindromeOdd(idx: Int, s: String): String {
        val prefixLen = 2 * idx + 1
        if (prefixLen >= s.length) return s

        val suffix = s.substring(prefixLen)
        return suffix.reversed() + s
    }

    private fun isPalindromePrefixEven(idx: Int, s: String): Boolean {
        var left = idx
        var right = idx + 1

        if (right >= s.length || s[left] != s[right]) return false
        while (left >= 0 && right < s.length) {
            if (s[left] != s[right]) return false
            left--
            right++
        }
        return true
    }

    private fun makePalindromeEven(idx: Int, s: String): String {
        val prefixLen = 2 * (idx + 1)
        if (prefixLen >= s.length) return s

        val suffix = s.substring(prefixLen)
        return suffix.reversed() + s
    }
}

