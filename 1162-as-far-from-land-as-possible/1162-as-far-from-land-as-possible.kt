class Solution {
    
    data class Position(val x: Int, val y: Int)
    val dx = intArrayOf(1, 0, -1, 0)
    val dy = intArrayOf(0, 1, 0, -1)
    val INF = 999999999
    
    fun isInBoundary(pos: Position, x: Int, y: Int): Boolean {
        if (0 <= pos.x && pos.x < x && 0 <= pos.y && pos.y < y) return true
        return false
    }
    
    fun bfs(grid: Array<IntArray>, lands: Queue<Position>, dist: Array<IntArray>): Int {
        var result = -1
        
        while(!lands.isEmpty()) {
            val current = lands.poll()
            val nextDistance = when(dist[current.x][current.y]) {
                -1 -> 1
                else -> dist[current.x][current.y] + 1
            }
            
            for (dir in 0 until 4) {
                val next = Position(current.x + dx[dir], current.y + dy[dir])
                if (!isInBoundary(next, grid.size, grid[0].size)) continue
                if (grid[next.x][next.y] == 1) continue
                if (dist[next.x][next.y] <= nextDistance) continue
                
                dist[next.x][next.y] = nextDistance
                result = maxOf(result, dist[next.x][next.y])
                lands.add(next)
            }
        }
        
        return result
    }
    
    fun maxDistance(grid: Array<IntArray>): Int {
        val lands: Queue<Position> = LinkedList()
        val dist = Array(grid.size) { IntArray(grid[0].size) }
        
        for (i in 0 until grid.size) {
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == 1) {
                    lands.add(Position(i, j))
                    dist[i][j] = -1
                }
                else {
                    dist[i][j] = INF
                }
            }
        }
        
        if (lands.size == 0 || lands.size == grid.size * grid[0].size)
            return -1
        
        return bfs(grid, lands, dist)
    }
}