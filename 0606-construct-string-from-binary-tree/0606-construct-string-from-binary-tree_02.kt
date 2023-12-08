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
    fun tree2str(root: TreeNode?): String {
        if (root == null) return ""
        val result = StringBuilder()
        traversal(root, result)
        return result.toString()
    }

    private fun traversal(root: TreeNode?, builder: StringBuilder) {
        if (root == null) return
        builder.append(root.`val`)

        if (root.left == null && root.right == null) return
        builder.append("(")
        traversal(root.left, builder)
        builder.append(")")
        
        if (root.right != null) {
            builder.append("(")
            traversal(root.right, builder)
            builder.append(")")
        }
    }
}

