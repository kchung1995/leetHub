class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val n = temperatures.size

        var hottestTemperature: Int = 0
        val result = IntArray(n)

        for (today in n - 1 downTo 0) {
            val todayTemperature = temperatures[today]
            if (todayTemperature >= hottestTemperature) {
                hottestTemperature = todayTemperature
                continue
            }

            var days: Int = 1
            while (temperatures[today + days] <= todayTemperature) {
                days += result[today + days]
            }
            result[today] = days
        }

        return result
    }
}

