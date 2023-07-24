class Solution {
    fun myPow(x: Double, n: Int): Double {
        return exponential(x, n.toLong())
    }

    private fun exponential(x: Double, n: Long): Double {
        if (n == 0L) return 1.0
        if (n < 0L) return 1.0 / exponential(x, -1 * n)

        return when (n % 2) {
            1L -> x * exponential(x * x, (n - 1) / 2)
            else -> exponential(x * x, n / 2)
        }
    }
}

