class Solution {
    companion object {
        private val MOD: Long = 1000000007
        private const val APPLE = 'A'
    }

    fun ways(pizza: Array<String>, k: Int): Int {
        val rows = pizza.size
        val columns = pizza[0].length

        val apples = Array(rows + 1) { LongArray(columns + 1) }
        val dp = Array(k) { Array(rows) { LongArray(columns) } }

        (rows - 1 downTo 0).forEach { row ->
            (columns - 1 downTo 0).forEach { column ->
                apples[row][column] = (if (pizza[row][column] == APPLE) 1 else 0) +
                    apples[row + 1][column] +
                    apples[row][column + 1] -
                    apples[row + 1][column + 1]
                dp[0][row][column] = if (apples[row][column] > 0) 1 else 0
            }
        }

        (1 until k).forEach { remain ->
            (0 until rows).forEach { row ->
                (0 until columns).forEach { column ->
                    (row + 1 until rows).forEach { nextRow ->
                        if (apples[row][column] - apples[nextRow][column] <= 0) return@forEach
                        dp[remain][row][column] += dp[remain - 1][nextRow][column]
                        dp[remain][row][column] %= MOD
                    }
                    (column + 1 until columns).forEach { nextColumn ->
                        if (apples[row][column] - apples[row][nextColumn] <= 0) return@forEach
                        dp[remain][row][column] += dp[remain - 1][row][nextColumn]
                        dp[remain][row][column] %= MOD
                    }
                }
            }
        }

        return dp[k - 1][0][0].toInt()
    }
}

