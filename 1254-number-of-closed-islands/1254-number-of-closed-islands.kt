data class Coordinate(val x: Int, val y: Int)

class Solution {
    val dx = listOf(0, 1, 0, -1)
    val dy = listOf(1, 0, -1, 0)

    fun closedIsland(grid: Array<IntArray>): Int {
        val visited = Array(grid.size) { IntArray(grid[0].size) { Integer.MAX_VALUE } }
        val n = grid.size
        val m = grid[0].size
        var result = 0

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (!isWall(i, j, grid) && visited[i][j] == Integer.MAX_VALUE) {
                    if (bfs(i, j, grid, visited, n, m) != -1) result++
                }
            }
        }

        return result
    }

    private fun bfs(x: Int, y: Int, grid: Array<IntArray>, visited: Array<IntArray>, n: Int, m: Int): Int {
        val start = Coordinate(x, y)
        visited[x][y] = 1
        val q: Queue<Coordinate> = LinkedList<Coordinate>()
        q.add(start)

        val boundaryCells = mutableListOf<Coordinate>()

        while(q.isNotEmpty()) {
            val current = q.poll()

            for (dir in 0 until 4) {
                val nx = current.x + dx[dir]
                val ny = current.y + dy[dir]

                if (isNotClosedIsland(nx, ny, n, m)) {
                    boundaryCells.add(current)
                    continue
                }
                if (isWall(nx, ny, grid)) continue
                val nextDistance = visited[current.x][current.y] + 1
                if (visited[nx][ny] > nextDistance) {
                    visited[nx][ny] = nextDistance
                    q.add(Coordinate(nx, ny))
                }
            }
        }

        for (cell in boundaryCells) {
            if (!isWall(cell.x, cell.y, grid)) {
                return -1
            }
        }

        return 0
    }

    private fun isNotClosedIsland(x: Int, y: Int, n: Int, m: Int) = x < 0 || x >= n || y < 0 || y >= m

    private fun isWall(x: Int, y: Int, grid: Array<IntArray>) = grid[x][y] == 1
}
