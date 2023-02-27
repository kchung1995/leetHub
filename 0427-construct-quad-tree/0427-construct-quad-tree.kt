/**
 * Definition for a QuadTree node.
 * class Node(var `val`: Boolean, var isLeaf: Boolean) {
 *     var topLeft: Node? = null
 *     var topRight: Node? = null
 *     var bottomLeft: Node? = null
 *     var bottomRight: Node? = null
 * }
 */

class Solution {
    fun Int.toBoolean() = if (this == 0) false else true
    
    fun isAllSame(grid: Array<IntArray>, x: Int, y: Int, gridSize: Int): Boolean {
        for (i in 0 until gridSize) {
            for (j in 0 until gridSize) {
                if (grid[x][y] != grid[x + i][y + j]) return false
            }
        }
        return true
    }
    
    fun recursive(grid: Array<IntArray>, x: Int, y: Int, gridSize: Int): Node {
        // return isLeaf node if all values are equal
        if (isAllSame(grid, x, y, gridSize)) {
            return Node(grid[x][y].toBoolean(), isLeaf = true)
        }
        
        // if not, recursive approach
        val nextSize = gridSize / 2
        val result = Node(true, false)
        result.topLeft = recursive(grid, x, y, nextSize)
        result.topRight = recursive(grid, x, y + nextSize, nextSize)
        result.bottomLeft = recursive(grid, x + nextSize, y, nextSize)
        result.bottomRight = recursive(grid, x + nextSize, y + nextSize, nextSize)
        return result
    }
    
    fun construct(grid: Array<IntArray>): Node? {
        return recursive(grid, 0, 0, grid.size)
    }
}