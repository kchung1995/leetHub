class Solution {
    fun minCost(colors: String, neededTime: IntArray): Int {
        var result: Int = 0
        val n = neededTime.size

        var i: Int = 0
        var j: Int = 0
        while (i < n && j < n) {
            var currentTotal: Int = 0
            var currentMax: Int = 0

            while (j < n && colors[i] == colors[j]) {
                currentTotal += neededTime[j]
                currentMax = maxOf(currentMax, neededTime[j])
                j++
            }

            result += currentTotal - currentMax
            i = j
        }

        return result
    }
}

