class Solution {
    fun firstPalindrome(words: Array<String>): String {
        for (word in words) {
            if (word.isPalindromic()) return word
        }
        return ""
    }

    private fun String.isPalindromic(): Boolean {
        val n = this.length
        for (i in 0 until n / 2) {
            if (this[i] != this[n - i - 1]) return false
        }
        
        return true
    }
}

