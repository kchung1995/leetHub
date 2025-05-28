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
    fun sumRootToLeaf(root: TreeNode?): Int {
        if (root == null) return 0

        return traverse(root.`val`.toString(), root)
    }

    private fun traverse(previous: String, node: TreeNode): Int {
        if (previous != "" && node.isLast()) return previous.toInt(2)
        
        val leftTraverseResult = node.left?.let { traverse(previous + it.`val`.toString(), it) } ?: 0
        val rightTraverseResult = node.right?.let { traverse(previous + it.`val`.toString(), it) } ?: 0

        return leftTraverseResult + rightTraverseResult
    }

    private fun TreeNode.isLast() = this.left == null && this.right == null
}

