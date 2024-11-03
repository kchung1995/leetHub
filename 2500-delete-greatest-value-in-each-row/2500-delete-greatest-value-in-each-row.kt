class Solution {
    fun deleteGreatestValue(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        var result: Int = 0
        
        grid.forEach { it.sort() }
        for (j in 0 until m) {
            val maxOfColumn = (0 until n)
            .map { grid[it][j] }
            .max()
            result += maxOfColumn
        }

        return result
    }
}

