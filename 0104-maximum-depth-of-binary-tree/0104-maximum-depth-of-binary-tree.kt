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
    fun explore(root: TreeNode?, depth: Int): Int {
        if (root == null) return 0
        if (root.left == null && root.right == null) return depth
        return maxOf(explore(root.left, depth + 1), explore(root.right, depth + 1))
    }

    fun maxDepth(root: TreeNode?): Int {
        return explore(root, 1)
    }
}