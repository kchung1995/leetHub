class Solution {
    companion object {
        private const val MOD: Long = 1_000_000_007
    }

    private var m: Int = 0
    private var n: Int = 0
    
    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        val memo = Array(m) { Array(n) { LongArray(maxMove + 1) { -1 } } }
        this.m = m
        this.n = n
        return memoization(maxMove, startRow, startColumn, memo)
    }

    private fun memoization(maxMove: Int, startRow: Int, startColumn: Int, memo: Array<Array<LongArray>>): Int {
        if (startRow == m || startColumn == n || startRow < 0 || startColumn < 0) return 1
        if (maxMove == 0) return 0
        if (memo[startRow][startColumn][maxMove] >= 0) return memo[startRow][startColumn][maxMove].toInt()

        val moveRow = memoization(maxMove - 1, startRow - 1, startColumn, memo) + memoization(maxMove - 1, startRow + 1, startColumn, memo) % MOD
        val moveColumn = memoization(maxMove - 1, startRow, startColumn - 1, memo) + memoization(maxMove - 1, startRow, startColumn + 1, memo) % MOD
        memo[startRow][startColumn][maxMove] = (moveRow + moveColumn) % MOD

        return memo[startRow][startColumn][maxMove].toInt()
    }
}

