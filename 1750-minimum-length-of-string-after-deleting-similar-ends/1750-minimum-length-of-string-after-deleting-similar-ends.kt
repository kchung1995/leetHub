class Solution {
    fun minimumLength(s: String): Int {
        var begin: Int = 0
        var end: Int = s.length - 1

        while (begin < end && s[begin] == s[end]) {
            val currentCharacter = s[begin]

            while (begin <= end && s[begin] == currentCharacter) begin++
            while (begin < end && s[end] == currentCharacter) end--
        }

        return end - begin + 1
    }
}

