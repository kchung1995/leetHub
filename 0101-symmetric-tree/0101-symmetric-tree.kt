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
    fun treeChildrenCheck(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) return true
        if (left == null || right == null) return false
        if (left.`val` != right.`val`) return false
        
        return (
            treeChildrenCheck(left.left, right.right)
            && treeChildrenCheck(left.right, right.left)
                )
        
    }
    
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        return treeChildrenCheck(root.left, root.right)
    }
}