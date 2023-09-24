class Solution {
    fun longestNiceSubstring(s: String): String {
        val n = s.length
        var result: String = ""

        for (i in 0 until n) {
            val uppers = MutableList<Int>(26) { 0 }
            val lowers = MutableList<Int>(26) { 0 }
            for (j in i until n) {
                val c = s[j]
                val index = if (c.isUpperCase()) (c - 'A').toInt() else (c - 'a').toInt()
                println(index)
                if (c.isUpperCase()) uppers[index] = 1 else lowers[index] = 1

                if (uppers == lowers && j - i + 1 > result.length)
                    result = s.substring(i, j + 1)
            }
        }
        
        return result
    }
}

