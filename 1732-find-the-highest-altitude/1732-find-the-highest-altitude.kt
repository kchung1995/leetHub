class Solution {
    fun largestAltitude(gain: IntArray): Int {
        var result: Int = 0
        var currentSum: Int = 0

        gain.asSequence().forEach { altitude ->
            currentSum += altitude
            result = maxOf(result, currentSum)
        }
        return result
    }
}

