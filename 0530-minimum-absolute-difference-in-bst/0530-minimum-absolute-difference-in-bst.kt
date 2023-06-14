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
    val inorderNodes = mutableListOf<Int>()

    fun getMinimumDifference(root: TreeNode?): Int {
        inorderTraversal(root)

        var result: Int = Integer.MAX_VALUE
        for (i in 1 until inorderNodes.size) {
            result = minOf(result, inorderNodes[i] - inorderNodes[i - 1])
        }
        return result
    }

    fun inorderTraversal(node: TreeNode?) {
        if (node == null) return
        inorderTraversal(node.left)
        inorderNodes.add(node.`val`)
        inorderTraversal(node.right)
    }
}

