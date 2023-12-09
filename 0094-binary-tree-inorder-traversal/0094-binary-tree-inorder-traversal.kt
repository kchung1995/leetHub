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
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        traversal(root, result)
        return result
    }

    fun traversal(root: TreeNode?, collected: MutableList<Int>) {
        if (root == null) return
        traversal(root.left, collected)
        collected.add(root.`val`)
        traversal(root.right, collected)
    }
}

