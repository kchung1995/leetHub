class Solution {
    fun maxVowels(s: String, k: Int): Int {
        var current: Int = 0
        var result: Int = 0

        for (i in 0 until k) {
            if (isVowel(s[i])) current++
        }
        result = current

        for (i in 0 until s.length - k) {
            if (isVowel(s[i])) current--
            if (isVowel(s[i + k])) current++
            result = maxOf(result, current)
        }
        return result
    }

    private fun isVowel(character: Char): Boolean = character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u'
}

