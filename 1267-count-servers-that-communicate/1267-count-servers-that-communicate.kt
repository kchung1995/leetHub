class Solution {
    fun countServers(grid: Array<IntArray>): Int {
        val n = grid.size
        val m = grid[0].size
        var communicatableServers: Int = 0

        for (row in 0 until n) {
            for (column in 0 until m) {
                if (grid[row][column] != 1) continue
                
                var canCommunicate: Boolean = false
                for (i in 0 until m) {
                    if (column != i && grid[row][i] == 1) {
                        canCommunicate = true
                        break
                    }
                }

                if (canCommunicate) communicatableServers++
                else {
                    for (i in 0 until n) {
                        if (row != i && grid[i][column] == 1) {
                            canCommunicate = true
                            break
                        }
                    }
                    if (canCommunicate) communicatableServers++
                }
            }
        }

        return communicatableServers
    }
}

