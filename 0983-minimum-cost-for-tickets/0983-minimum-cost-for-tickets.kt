class Solution {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val ONE_DAY_PASS = costs[0]
        val SEVEN_DAY_PASS = costs[1]
        val THIRTY_DAY_PASS = costs[2]
        val dp = IntArray(366)

        var dayIndex: Int = 0
        for (day in 1..365) {
            if (dayIndex >= days.size) break
            when (day == days[dayIndex]) {
                true -> {
                    dp[day] = minOf(
                        dp[day - 1] + ONE_DAY_PASS,
                        dp[sevenDaysAgo(day)] + SEVEN_DAY_PASS,
                        dp[thirtyDaysAgo(day)] + THIRTY_DAY_PASS
                    )
                    dayIndex++
                }
                else -> dp[day] = dp[day - 1]
            }
        }

        return dp[days.last()]
    }

    private fun sevenDaysAgo(day: Int): Int = maxOf(day - 7, 0)

    private fun thirtyDaysAgo(day: Int): Int = maxOf(day - 30, 0)
}
