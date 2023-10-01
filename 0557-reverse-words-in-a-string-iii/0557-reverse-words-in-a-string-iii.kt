class Solution {
    fun reverseWords(s: String): String {
        return s.split(' ')
            .asSequence()
            .map { word -> word.reversed() }
            .joinToString(separator = " ")
    }
}
