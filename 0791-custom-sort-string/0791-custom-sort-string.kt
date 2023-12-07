class Solution {
    fun customSortString(order: String, s: String): String {
        val count = IntArray(26)
        for (c in s)
            count[c - 'a']++

        val result = StringBuilder()
        for (c in order) {
            repeat(count[c - 'a']) {
                result.append(c)
            }
            count[c - 'a'] = 0
        }

        for (c in 'a'..'z') {
            repeat(count[c - 'a']) {
                result.append(c)
            }
        }

        return result.toString()
    }
}

