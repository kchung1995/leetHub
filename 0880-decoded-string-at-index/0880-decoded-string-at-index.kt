class Solution {
    fun decodeAtIndex(s: String, k: Int): String {
        var size: Long = 0

        for (currentChar in s) {
            if (currentChar.isDigit()) size *= (currentChar - '0')
            else size++
        }

        var index = k.toLong()
        for (i in s.length - 1 downTo 0) {
            index %= size
            if (index == 0L && Character.isLetter(s[i])) return s[i].toString()
            if (Character.isDigit(s[i])) size /= (s[i] - '0')
            else size--
        }

        throw IllegalArgumentException()
    }
}

