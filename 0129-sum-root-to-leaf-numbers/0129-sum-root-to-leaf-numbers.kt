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
    fun getSum(root: TreeNode, num: Int): Int {
        val nextNum = (num * 10) + root.`val`
        if (root.left == null && root.right == null) return nextNum
        return (root.left?.let { getSum(it, nextNum) } ?: 0) + (root.right?.let { getSum(it, nextNum) } ?: 0)
    }
    
    fun sumNumbers(root: TreeNode?): Int {
        if (root == null) return 0
        return getSum(root, 0)
    }
}