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
    fun findMode(root: TreeNode?): IntArray {
        val numberCount = HashMap<Int, Int>()
        dfs(root, numberCount)
        val maxFrequent: Int = numberCount.maxBy { it.value }.value

        val result: List<Int> = numberCount.filter {it.value == maxFrequent }.map { it.key }
        return result.toIntArray()
    }

    private fun dfs(node: TreeNode?, numberCount: HashMap<Int, Int>) {
        if (node == null) return
        numberCount[node.`val`] = numberCount.getOrDefault(node.`val`, 0) + 1
        dfs(node.left, numberCount)
        dfs(node.right, numberCount)
    }
}

