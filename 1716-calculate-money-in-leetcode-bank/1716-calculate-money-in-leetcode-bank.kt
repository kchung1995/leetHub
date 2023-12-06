class Solution {
    fun totalMoney(n: Int): Int {
        val k = n / 7
        val firstElement = 28
        val finalElement = 7 * (k - 1) + 28
        val fullWeeksSum = k * (firstElement + finalElement) / 2

        val monday = 1 + k
        var finalWeekSum = 0
        for (i in 0 until n % 7) {
            finalWeekSum += (monday + i)
        }

        return fullWeeksSum + finalWeekSum
    }
}

