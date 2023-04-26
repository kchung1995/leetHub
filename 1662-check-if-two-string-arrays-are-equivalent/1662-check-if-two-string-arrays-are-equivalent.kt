class Solution {
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        val one = composeToString(word1)
        val two = composeToString(word2)
        return one == two
    }

    private fun composeToString(word: Array<String>): String {
        val sb = StringBuffer()
        for (i in word) {
            sb.append(i)
        }
        return sb.toString()
    }
}

