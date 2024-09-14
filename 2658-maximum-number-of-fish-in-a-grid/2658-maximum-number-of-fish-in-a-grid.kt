class Solution {
    var n: Int = -1
    var m: Int = -1

    fun findMaxFish(grid: Array<IntArray>): Int {
        var result: Int = 0
        n = grid.size
        m = grid[0].size

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (grid[i][j] != 0) {
                    result = maxOf(result, search(Coordinate(i, j), grid))
                }
            }
        }

        return result
    }

    private fun search(at: Coordinate, grid: Array<IntArray>): Int {
        var fishCollected = grid[at.x][at.y]
        grid[at.x][at.y] = 0

        for (i in 0 until 4) {
            val nextCoordinate = at.move(i)
            if (nextCoordinate.isInBoundary(n, m).not()) continue
            if (grid[nextCoordinate.x][nextCoordinate.y] == 0) continue
            fishCollected += search(nextCoordinate, grid)
        }

        return fishCollected
    }

    data class Coordinate(val x: Int, val y: Int) {
        fun isInBoundary(xMax: Int, yMax: Int) = 0 <= x && x < xMax && 0 <= y && y < yMax

        fun move(dir: Int) = Coordinate(this.x + dx[dir], this.y + dy[dir])

        companion object {
            val dx = listOf(0, 1, 0, -1)
            val dy = listOf(1, 0, -1, 0)
        }
    }
}

