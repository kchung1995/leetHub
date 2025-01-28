class Solution {
    private val dx = listOf(1, 0, -1, 0)
    private val dy = listOf(0, 1, 0, -1)

    private var rLimit: Int = -1
    private var cLimit: Int = -1

    fun findMaxFish(grid: Array<IntArray>): Int {
        rLimit = grid.size
        cLimit = grid[0].size
        
        val visited: Array<BooleanArray> = Array(rLimit) { BooleanArray(cLimit) { false } }
        var result: Int = 0

        for (i in 0 until rLimit) {
            for (j in 0 until cLimit) {
                if (visited[i][j] == false && grid[i][j] > 0) {
                    result = maxOf(result, dfs(i, j, grid, visited))
                }
            }
        }
        
        return result
    }

    private fun dfs(rPos: Int, cPos: Int, grid: Array<IntArray>, visited: Array<BooleanArray>): Int {
        require(grid.isWater(rPos, cPos))
        var sum: Int = grid[rPos][cPos]
        visited[rPos][cPos] = true

        (0 until 4).forEach { dir ->
            val nr = rPos + dx[dir]
            val nc = cPos + dy[dir]

            if (isInBoundary(nr, nc) && visited.isVisited(nr, nc).not() && grid.isWater(nr, nc)) {
                sum += dfs(nr, nc, grid, visited)
            }
        }

        return sum
    }

    private fun Array<BooleanArray>.isVisited(rAt: Int, cAt: Int) = this[rAt][cAt] == true

    private fun Array<IntArray>.isWater(rAt: Int, cAt: Int) = this[rAt][cAt] > 0

    private fun isInBoundary(r: Int, c: Int): Boolean =
        0 <= r && r < rLimit && 0 <= c && c < cLimit
}

