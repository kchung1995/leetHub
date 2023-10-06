class Solution {
    fun integerBreak(n: Int): Int {
        when {
            n <= 3 -> return n - 1
            n % 3 == 0 -> return powerOf(3, n / 3)
            n % 3 == 1 -> return powerOf(3, (n / 3 - 1)) * 4
        }
        return powerOf(3, n / 3) * 2
    }

    private fun powerOf(base: Int, power: Int): Int {
        var result: Int = 1
        for (i in 1..power) result *= base
        return result
    }
}
