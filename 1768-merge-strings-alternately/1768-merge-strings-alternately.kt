class Solution {
    fun mergeAlternately(word1: String, word2: String): String {
        val oneLength = word1.length
        val twoLength = word2.length
        val n = maxOf(oneLength, twoLength)
        val sb = StringBuilder()

        for (i in 0 until n) {
            if (i < oneLength) sb.append(word1[i])
            if (i < twoLength) sb.append(word2[i])
        }
        return sb.toString()
    }
}

