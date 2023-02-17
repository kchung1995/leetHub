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
    
    var INF: Int = Integer.MAX_VALUE
    var prevRootValue: Int = INF
    var result: Int = INF
    
    fun findMinimumDifferenceDfs(root: TreeNode?) {
        if (root == null) return
        if (root.left != null) findMinimumDifferenceDfs(root.left)
        if (prevRootValue != INF) result = minOf(result, root.`val` - prevRootValue)
        prevRootValue = root.`val`
        if (root.right != null) findMinimumDifferenceDfs(root.right)
        return
    }
    
    fun minDiffInBST(root: TreeNode?): Int {
        findMinimumDifferenceDfs(root)
        return result
    }
}