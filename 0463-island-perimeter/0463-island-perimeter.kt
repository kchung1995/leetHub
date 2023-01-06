class Solution {
    
    val dx: Array<Int> = arrayOf(-1, 0, 1, 0)
    val dy: Array<Int> = arrayOf(0, 1, 0, -1)
    
    fun isInBoundary(x: Int, y: Int, width: Int, height: Int): Boolean = 
        if (0 <= x && x < width && 0 <= y && y < height) true
        else false
    
    fun numberOfBoundary(grid: Array<IntArray>, x: Int, y: Int): Int {
        var result = 0
        val height = grid.size
        val width = grid[0].size
        
        for (dir in 0 until 4) {
            val nx = x + dx[dir]
            val ny = y + dy[dir]
            
            if (!isInBoundary(nx, ny, height, width) || grid[nx][ny] == 0) {
                result++
            }
        }
        
        return result
    }

    fun islandPerimeter(grid: Array<IntArray>): Int {
        var q: Queue<Pair<Int, Int>> = LinkedList()
        // find the first point to start BFS
        for (i in 0 until grid.size) {
            var temp: Boolean = false
            for (j in 0 until grid[0].size) {
                if (grid[i][j] == 1) {
                    q.add(Pair(i, j))
                    temp = true
                    break
                }
            }
            if (temp) break
        }
        
        val height = grid.size
        val width = grid[0].size
        val isVisited = Array(height) { BooleanArray(width) }
        
        var result: Int = 0
        isVisited[q.peek().first][q.peek().second] = true
        
        while(!q.isEmpty()) {
            val cx = q.peek().first
            val cy = q.peek().second
            q.remove()
            
            result += numberOfBoundary(grid, cx, cy)
            
            for (dir in 0 until 4) {
                val nx = cx + dx[dir]
                val ny = cy + dy[dir]
                
                if (!isInBoundary(nx, ny, height, width)) {
                    continue
                }
                if (grid[nx][ny] == 0 || isVisited[nx][ny]) {
                    continue
                }
                isVisited[nx][ny] = true
                q.add(Pair(nx, ny))
            }
        }
        
        return result
    }
}