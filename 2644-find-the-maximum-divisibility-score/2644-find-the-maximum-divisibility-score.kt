class Solution {
    fun maxDivScore(nums: IntArray, divisors: IntArray): Int {
        var currentMaxDivisibility: Int = -1
        var result: Int = 0

        for (divisor in divisors) {
            var divisibilityCount: Int = 0
            for (number in nums) {
                if (number % divisor == 0) divisibilityCount++
            }

            if (divisibilityCount == currentMaxDivisibility) {
                result = minOf(result, divisor)
            }
            if (divisibilityCount > currentMaxDivisibility) {
                result = divisor
                currentMaxDivisibility = divisibilityCount
            }
        }

        return result
    }
}
