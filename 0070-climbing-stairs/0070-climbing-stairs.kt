class Solution {
    fun climbStairs(n: Int): Int {
        if (n == 1) return 1

        var first: Int = 1
        var second: Int = 2
        for (i in 3..n) {
            val third = first + second
            first = second
            second = third
        }

        return second
    }
}

