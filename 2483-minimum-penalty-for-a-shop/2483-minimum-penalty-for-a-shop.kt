class Solution {
    fun bestClosingTime(customers: String): Int {
        var minimumPenalty = 0
        var currentPenalty = 0
        var earliestHour = 0

        for (i  in 0 until customers.length) {
            when (customers[i]) {
                'Y' -> currentPenalty--
                else -> currentPenalty++
            }

            if (currentPenalty < minimumPenalty) {
                earliestHour = i + 1
                minimumPenalty = currentPenalty
            }
        }

        return earliestHour
    }
}

