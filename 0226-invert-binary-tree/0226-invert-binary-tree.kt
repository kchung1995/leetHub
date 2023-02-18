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
    fun treeInvertDfs(root: TreeNode?): TreeNode? {
        if (root == null) return null
        root.left = treeInvertDfs(root.right)
            .also { root.right = treeInvertDfs(root.left) }
        return root
    }
    
    fun invertTree(root: TreeNode?): TreeNode? {
        return treeInvertDfs(root)
    }
}