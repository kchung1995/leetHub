class Solution {
    fun numSplits(s: String): Int {
        val leftArray = IntArray(26)
        val rightArray = IntArray(26)

        var left: Int = 0
        var right: Int = 0
        var result: Int = 0

        for (i in s) {
            if (++rightArray[i - 'a'] == 1) right++
        }
        for (i in s) {
            if (++leftArray[i - 'a'] == 1) left++
            if (--rightArray[i - 'a'] == 0) right--
            if (left == right) result++
        }

        return result
    }
}

