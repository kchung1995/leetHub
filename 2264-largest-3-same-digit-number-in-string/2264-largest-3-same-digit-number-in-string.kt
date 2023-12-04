class Solution {
    fun largestGoodInteger(num: String): String {
        var start: Int = 0
        val windowSize = 3

        var result: Int? = null

        for (i in 0 until num.length - windowSize + 1) {
            val currentString = num.substring(i, i + windowSize)
            if (isSameDigitNumber(currentString)) {
                val currentInt = currentString.toInt()
                if (result == null) result = currentInt
                else result = maxOf(result, currentInt)
            }
        }

        return result?.toString()?.padStart(windowSize, '0') ?: ""
    }

    private fun isSameDigitNumber(num: String) = num[0] == num[1] && num[1] == num[2]
}

