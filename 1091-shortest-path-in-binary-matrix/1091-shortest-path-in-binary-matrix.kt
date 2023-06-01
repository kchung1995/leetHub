data class Coordinate(val x: Int, val y: Int)

class Solution {
    private val dir = listOf(
        Coordinate(0, 1),
        Coordinate(1, 0),
        Coordinate(0, -1),
        Coordinate(-1, 0),
        Coordinate(1, 1),
        Coordinate(1, -1),
        Coordinate(-1, 1),
        Coordinate(-1, -1)
    )

    private var n: Int = 0

    private fun isInBoundary(now: Coordinate) = if (0 <= now.x && now.x < n && 0 <= now.y && now.y < n) true else false

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        n = grid.size
        val visited = Array(n) { IntArray(n) { Integer.MAX_VALUE } }
        val q: Queue<Coordinate> = LinkedList<Coordinate>()
        if (grid[0][0] == 0) {
            visited[0][0] = 1
            q.add(Coordinate(0, 0))
        }

        while(q.isNotEmpty()) {
            val current = q.poll()
            dir.map { dir ->
                val next = Coordinate(current.x + dir.x, current.y + dir.y)
                if (!isInBoundary(next)) return@map
                if (grid[next.x][next.y] == 1) return@map
                val nextDistance = visited[current.x][current.y] + 1
                if (visited[next.x][next.y] > nextDistance) {
                    visited[next.x][next.y] = nextDistance
                    q.add(next)
                }
            }
        }

        return if (visited[n - 1][n - 1] == Integer.MAX_VALUE) -1 else visited[n - 1][n - 1]
    }
}
