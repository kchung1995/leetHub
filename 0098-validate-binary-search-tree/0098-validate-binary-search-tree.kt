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
    fun isValidBST(root: TreeNode?): Boolean = validate(root, null, null)

    private fun validate(root: TreeNode?, low: Int?, high: Int?): Boolean = when {
        root == null -> true
        low != null && root.`val` <= low -> false
        high != null && root.`val` >= high -> false
        else -> validate(root.left, low, root.`val`) && validate(root.right, root.`val`, high)
    }
}

