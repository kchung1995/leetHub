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
    fun findSecondMinimumValue(root: TreeNode?): Int {
        if (root == null) return FALLBACK
        if (root.left == null && root.right == null) return FALLBACK

        return traverse(root, root.`val`)
    }

    private fun traverse(root: TreeNode?, parentVal: Int): Int {
        if (root == null) return -1
        if (root.`val` > parentVal) return root.`val`

        val left = traverse(root.left, root.`val`)
        val right = traverse(root.right, root.`val`)

        if (left == -1 && right == -1) return -1
        if (left == -1) return right
        if (right == -1) return left

        return minOf(left, right)
    }

    companion object {
        const val FALLBACK = -1
    }
}

