class Solution {
    fun convertToTitle(columnNumber: Int): String {
        var result: String = ""
        var current = columnNumber

        while (current > 0) {
            current--
            result += ((current % 26) + 'A'.toInt()).toChar()
            current /= 26
        }

        return result.reversed()
    }
}

