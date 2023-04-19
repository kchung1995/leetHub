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
    fun longestZigZag(root: TreeNode?): Int {
        if (root == null) return 0
        
        val result = IntArray(1)
        search(root, result)
        return result[0] - 1
    }

    private fun search(root: TreeNode?, result: IntArray): IntArray {
        if (root == null) return intArrayOf(0, 0)

        val left = search(root.left, result)
        val right = search(root.right, result)
        
        result[0] = maxOf(result[0], left[1] + 1, right[0] + 1)
        return intArrayOf(left[1] + 1, right[0] + 1)
    }
}

