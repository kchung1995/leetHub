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
    fun dfs(root: TreeNode?, result: StringBuilder) {
        if (root == null) return
        
        result.append(root.`val`.toString())
        if (root.left == null && root.right == null) return
        
        result.append("(")
        dfs(root.left, result)
        result.append(")")
        
        if (root.right != null) {
            result.append("(")
            dfs(root.right, result)
            result.append(")")
        }
    }
    
    fun tree2str(root: TreeNode?): String {
        val result = StringBuilder()
        dfs(root, result)
        return result.toString()
    }
}