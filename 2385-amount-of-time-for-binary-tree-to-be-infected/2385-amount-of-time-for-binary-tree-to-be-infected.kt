/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    var maxDistance: Int = 0
    
    fun amountOfTime(root: TreeNode?, start: Int): Int {
        dfs(root, start)
        return maxDistance
    }

    private fun dfs(root: TreeNode?, start: Int): Int {
        if (root == null) return 0

        var depth: Int = 0
        var leftDepth: Int = dfs(root.left, start)
        var rightDepth: Int = dfs(root.right, start)

        when {
            root.`val` == start -> {
                maxDistance = maxOf(leftDepth, rightDepth)
                depth = -1
            }
            leftDepth >= 0 && rightDepth >= 0 -> depth = maxOf(leftDepth, rightDepth) + 1;
            else -> {
                val distance = absolute(leftDepth) + absolute(rightDepth);
                maxDistance = maxOf(maxDistance, distance);
                depth = minOf(leftDepth, rightDepth) - 1;
            }
        }

        return depth
    }

    private fun absolute(value: Int): Int = if (value < 0) -value else value
}

