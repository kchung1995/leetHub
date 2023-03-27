data class Coordinate(val x: Int, val y: Int)

class Solution {
    private val move = listOf(Coordinate(1, 0), Coordinate(0, 1))

    private fun isInBoundary(at: Coordinate, max: Coordinate): Boolean = 0 <= at.x && at.x <= max.x && 0 <= at.y && at.y <= max.y

    fun minPathSum(grid: Array<IntArray>): Int {
        val from = Coordinate(0, 0)
        val to = Coordinate(grid.size - 1, grid[0].size - 1)

        val distance = Array(to.x + 1) {Array(to.y + 1) { Integer.MAX_VALUE } }
        val q: Queue<Coordinate> = LinkedList<Coordinate>()

        distance[from.x][from.y] = grid[from.x][from.y]
        q.add(from)

        while (q.isNotEmpty()) {
            val current = q.poll()

            for (new in move) {
                val next = Coordinate(current.x + new.x, current.y + new.y)
                if (!isInBoundary(next, to)) continue
                if (distance[next.x][next.y] > distance[current.x][current.y] + grid[next.x][next.y]) {
                    distance[next.x][next.y] = distance[current.x][current.y] + grid[next.x][next.y]
                    if (next != to) q.add(next)
                }
            }
        }

        return distance[to.x][to.y]
    }
}
