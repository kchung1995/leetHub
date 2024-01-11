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
    var maximumDifferenceBetweenNodeAndAncestor: Int = 0

    fun maxAncestorDiff(root: TreeNode?): Int {
        requireNotNull(root)
        dfs(root, root.`val`, root.`val`)
        return maximumDifferenceBetweenNodeAndAncestor
    }

    private fun dfs(node: TreeNode?, maxAncestor: Int, minAncestor: Int) {
        if (node == null) return
        maximumDifferenceBetweenNodeAndAncestor = maxOf(
            maximumDifferenceBetweenNodeAndAncestor,
            absoluteDifference(node.`val`, maxAncestor),
            absoluteDifference(node.`val`, minAncestor)
        )

        val newMaxAncestor: Int = maxOf(maxAncestor, node.`val`)
        val newMinAncestor: Int = minOf(minAncestor, node.`val`)

        dfs(node.left, newMaxAncestor, newMinAncestor)
        dfs(node.right, newMaxAncestor, newMinAncestor)
    }

    private fun absoluteDifference(a: Int, b: Int): Int {
        val result = a - b
        return if (result < 0) -result else result
    }
}

