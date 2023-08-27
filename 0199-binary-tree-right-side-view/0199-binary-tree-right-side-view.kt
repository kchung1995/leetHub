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
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()

        val queue: Queue<Pair<TreeNode, Int>> = LinkedList<Pair<TreeNode, Int>>()
        if (root == null) return result
        queue.add(Pair(root, 0))
        var depthLevel: Int = 0

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            val currentNode = current.first
            val currentDepth = current.second

            if (currentNode.right != null) {
                queue.add(Pair(currentNode.right, currentDepth + 1))
            }
            if (currentNode.left != null) {
                queue.add(Pair(currentNode.left, currentDepth + 1))
            }

            if (currentDepth == depthLevel) {
                result.add(currentNode.`val`)
                depthLevel++
            }
        }

        return result
    }
}

