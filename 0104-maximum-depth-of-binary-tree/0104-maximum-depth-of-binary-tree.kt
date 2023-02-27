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
    fun getDepth(root: TreeNode?, currentDepth: Int): Int {
        if (root == null) return currentDepth
        return maxOf(getDepth(root.left, currentDepth + 1), getDepth(root.right, currentDepth + 1))
    }
    
    fun maxDepth(root: TreeNode?): Int {
        return getDepth(root, 0)
    }
}