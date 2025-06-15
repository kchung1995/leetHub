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
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        
        val results = mutableListOf<MutableList<Int>>()
        dfs(root, 0, results)
        return results
    }

    private fun dfs(node: TreeNode, level: Int, results: MutableList<MutableList<Int>>) {
        when {
            level >= results.size -> {
                val newLevel = mutableListOf<Int>()
                newLevel.add(node.`val`)
                results.add(newLevel)
            }

            level % 2 == 0 -> results[level].add(node.`val`)

            else -> results[level].add(0, node.`val`)
        }

        if (node.left != null) dfs(node.left, level + 1, results)
        if (node.right != null) dfs(node.right, level + 1, results)
    }
}

