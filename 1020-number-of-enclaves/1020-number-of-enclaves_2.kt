data class Coordinate(val x: Int, val y: Int)

class Solution {
    private val directions = arrayOf(
        Coordinate(1, 0),
        Coordinate(0, 1),
        Coordinate(-1, 0),
        Coordinate(0, -1)
    )

    private var n: Int = 0
    private var m: Int = 0

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
                val next = Coordinate(current.x + directions[dir].x, current.y + directions[dir].y)

                if (isOutsideGrid(next)) {
                    isFacingOutside = true
                    continue
                }
                if (isLand(next, grid) && !visited[next.x][next.y]) {
                    visited[next.x][next.y] = true
                    result++
                    q.add(next)
                }
            }
        }
        
        if (isFacingOutside) return 0
        return result
    }

    private fun isOutsideGrid(now: Coordinate) = now.x < 0 || now.x >= n || now.y < 0 || now.y >= m

    private fun isSea(x: Int, y: Int, grid: Array<IntArray>) = grid[x][y] == 0

    private fun isSea(now: Coordinate, grid: Array<IntArray>) = grid[now.x][now.y] == 0

    private fun isLand(x: Int, y: Int, grid: Array<IntArray>) = grid[x][y] == 1

    private fun isLand(now: Coordinate, grid: Array<IntArray>) = grid[now.x][now.y] == 1
}
