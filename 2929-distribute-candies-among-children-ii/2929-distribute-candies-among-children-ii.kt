class Solution {
    fun distributeCandies(nI: Int, limitI: Int): Long {
        val n = nI.toLong()
        val limit = limitI.toLong()
        val limitOne = limit + 1

        val result = 
            calculate(n + 2) -
            3 * calculate(n - limit + 1) +
            3 * calculate(n - (2 * limitOne) + 2) -
            calculate(n - (3 * limitOne) + 2)

        return result
    }

    private fun calculate(x: Long): Long {
        if (x < 0) return 0
        return (x * (x - 1)) / 2
    }
}

