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
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val firstLeaves = mutableListOf<Int>()
        val secondLeaves = mutableListOf<Int>()

        dfs(root1, firstLeaves)
        dfs(root2, secondLeaves)

        return firstLeaves == secondLeaves
    }

    private fun dfs(node: TreeNode?, leaves: MutableList<Int>) {
        if (node == null) return
        if (node.left == null && node.right == null) leaves.add(node.`val`)
        dfs(node.left, leaves)
        dfs(node.right, leaves)
    }
}

