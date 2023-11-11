class Solution {
    fun checkValidString(s: String): Boolean {
        var low: Int = 0
        var high: Int = 0

        for (ch in s) {
            when (ch) {
                '(' -> {
                    low++
                    high++
                }
                ')' -> {
                    low = maxOf(0, --low)
                    high--
                }
                '*' -> {
                    low = maxOf(0, --low)
                    ++high;
                }
            }

            if (high < 0) return false
        }
        return low == 0
    }
}

