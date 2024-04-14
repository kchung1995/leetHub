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
    private val levels: MutableList<MutableList<Int>> = mutableListOf()

    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        if (root == null) return levels
        solve(root, 0)
        levels.reverse()
        return levels
    }

    private fun solve(node: TreeNode, level: Int) {
        if (levels.size == level) levels.add(mutableListOf())
        levels[level].add(node.`val`)

        if (node.left != null) solve(node.left, level + 1)
        if (node.right != null) solve(node.right, level + 1)
    }
}

