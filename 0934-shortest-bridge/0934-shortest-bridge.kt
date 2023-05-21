data class Coordinate(val x: Int, val y: Int) {
    companion object {
        fun add(a: Coordinate, b: Coordinate): Coordinate {
            return Coordinate(
                x = a.x + b.x,
                y = a.y + b.y
            )
        }
    }
}

class Solution {
    private val dr = listOf(Coordinate(1, 0), Coordinate(0, 1), Coordinate(-1, 0), Coordinate(0, -1))
    private var n: Int = 0

    fun shortestBridge(grid: Array<IntArray>): Int {
        n = grid.size

        val queue: Queue<Coordinate> = LinkedList<Coordinate>()
        var isFound: Boolean = false

        for (i in 0 until n) {
            if (isFound) break
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    dfs(grid, Coordinate(i, j), queue)
                    isFound = true
                    break
                }
            }
        }

        var steps: Int = 0
        while(queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val current = queue.poll()
                for (dir in 0 until 4) {
                    val next = Coordinate.add(current, dr[dir])
                    if (!isInBoundary(next)) continue
                    if (grid[next.x][next.y] == 1) return steps
                    if (grid[next.x][next.y] == 0) {
                        grid[next.x][next.y] = -1
                        queue.add(next)
                    }
                }
            }
            steps++
        }

        return steps
    }

    private fun dfs(grid: Array<IntArray>, current: Coordinate, queue: Queue<Coordinate>) {
        if (!isInBoundary(current)) return
        if (grid[current.x][current.y] != 1) return
        grid[current.x][current.y] = -1
        queue.add(current)

        for (dir in 0 until 4) {
            val next = Coordinate.add(current, dr[dir])
            dfs(grid, next, queue)
        }
    }

    private fun isInBoundary(current: Coordinate): Boolean = 0 <= current.x && current.x < n && 0 <= current.y && current.y < n
}

