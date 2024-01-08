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
    var result: Int = 0
    
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        dfs(root, low, high)
        return result
    }

    private fun dfs(root: TreeNode?, low: Int, high: Int) {
        if (root == null) return
        if (low <= root.`val` && root.`val` <= high)
            result += root.`val`
        if (low < root.`val`)
            dfs(root.left, low, high)
        if (root.`val` < high)
            dfs(root.right, low, high)
    }
}

