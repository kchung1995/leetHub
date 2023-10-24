class Solution {
    fun countSymmetricIntegers(low: Int, high: Int): Int {
        var result: Int = 0
        for (i in low..high) {
            if (isSymmetric(i)) result++
        }

        return result
    }

    private fun isSymmetric(value: Int): Boolean {
        if (value >= 10 && value <= 99) return value / 10 == value % 10;
        if (value >= 1000 && value <= 9999) {
            val left = value / 100;
            val right = value % 100;
            return left / 10 + left % 10 == right / 10 + right % 10;
        }
        return false;
    }
}

