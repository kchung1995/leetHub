data class Coordinate(val x: Int, val y: Int)

class Solution {
    private val dx = listOf(0, 1, 0, -1)
    private val dy = listOf(1, 0, -1, 0)

    var n: Int = 0
    var m: Int = 0

    fun numEnclaves(grid: Array<IntArray>): Int {
        n = grid.size
        m = grid[0].size

        val visited = Array(n) { BooleanArray(m) { false } }

        var result: Int = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (isLand(i, j, grid) && !visited[i][j]) {
                    result += bfs(i, j, grid, visited)
                }
            }
        }

        return result
    }

    private fun bfs(startX: Int, startY: Int, grid: Array<IntArray>, visited: Array<BooleanArray>): Int {
        var result: Int = 1
        var isFacingOutside = false
        val q: Queue<Coordinate> = LinkedList<Coordinate>()
        q.add(Coordinate(startX, startY))
        visited[startX][startY] = true

        while(q.isNotEmpty()) {
            val current = q.poll()

            for (dir in 0 until 4) {
                val nx = current.x + dx[dir]
                val ny = current.y + dy[dir]

                if (isOutsideGrid(nx, ny)) {
                    isFacingOutside = true
                    continue
                }
                if (isLand(nx, ny, grid) && !visited[nx][ny]) {
                    visited[nx][ny] = true
                    result++
                    q.add(Coordinate(nx, ny))
                }
            }
        }
        
        if (isFacingOutside) return 0
        return result
    }

    private fun isOutsideGrid(x: Int, y: Int) = x < 0 || x >= n || y < 0 || y >= m

    private fun isSea(x: Int, y: Int, grid: Array<IntArray>) = grid[x][y] == 0

    private fun isLand(x: Int, y: Int, grid: Array<IntArray>) = grid[x][y] == 1
}
