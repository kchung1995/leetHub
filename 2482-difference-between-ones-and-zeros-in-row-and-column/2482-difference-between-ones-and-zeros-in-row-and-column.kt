class Solution {
    fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
        val n = grid.size
        val m = grid[0].size

        val onesRow = IntArray(n)
        val onesColumn = IntArray(m)
        for (i in 0 until n) {
            for (j in 0 until m) {
                onesRow[i] += grid[i][j]
                onesColumn[j] += grid[i][j]
            }
        }

        val result = Array(n) { IntArray(m) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                result[i][j] = (2 * onesRow[i] + 2 * onesColumn[j]) - n - m
            }
        }

        return result
    }
}

