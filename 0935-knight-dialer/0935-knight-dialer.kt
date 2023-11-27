class Solution {
    private lateinit var memo: Array<IntArray>
    private var n: Int = 0
    private val MOD: Int = 1000000_007
    private val jumps: Array<IntArray> = arrayOf(
        intArrayOf(4, 6),
        intArrayOf(6, 8),
        intArrayOf(7, 9),
        intArrayOf(4, 8),
        intArrayOf(3, 9, 0),
        intArrayOf(),
        intArrayOf(1, 7, 0),
        intArrayOf(2, 6),
        intArrayOf(1, 3),
        intArrayOf(2, 4)
    )

    fun knightDialer(n: Int): Int {
        this.n = n
        memo = Array(n + 1) { IntArray(10) }
        var result = 0
        for (square in 0 until 10) {
            result = (result + dp(n - 1, square)) % MOD
        }

        return result
    }

    private fun dp(remain: Int, square: Int): Int {
        if (remain == 0) return 1
        if (memo[remain][square] != 0) return memo[remain][square]

        var result: Int = 0
        for (nextSquare in jumps[square]) {
            result = (result + dp(remain - 1, nextSquare)) % MOD
        }

        memo[remain][square] = result
        return result
    }
}

