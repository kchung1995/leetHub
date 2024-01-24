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
    var count: Int = 0

    fun pseudoPalindromicPaths (root: TreeNode?): Int {
        preorderTraversal(root, 0)
        return count
    }

    private fun preorderTraversal(node: TreeNode?, path: Int) {
        if (node == null) return
        val newPath = path xor (1 shl node.`val`)
        
        if (node.left == null && node.right == null) {
            if ((newPath and (newPath - 1)) == 0) {
                    count++
            }
        }
        preorderTraversal(node.left, newPath)
        preorderTraversal(node.right, newPath)
    }
}

