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
        if (root.left == null && root.right == null) return root
        if (root.right == null) {
            root.right = treeInvertDfs(root.left)
            root.left = null
            return root
        }
        val tempLeft = root.left
        root.left = treeInvertDfs(root.right)
        root.right = treeInvertDfs(tempLeft)
        return root
    }
    
    fun invertTree(root: TreeNode?): TreeNode? {
        return treeInvertDfs(root)
    }
}