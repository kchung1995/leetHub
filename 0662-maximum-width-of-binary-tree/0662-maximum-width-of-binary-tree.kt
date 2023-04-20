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
data class NodeDistance(val node: TreeNode, val distance: Int)

class Solution {

    fun widthOfBinaryTree(root: TreeNode?): Int {
        if (root == null) return 0

        val q: Queue<NodeDistance> = LinkedList<NodeDistance>()
        q.add(NodeDistance(root, 0))

        var result: Int = 0
        while(q.isNotEmpty()) {
            val currentLevelSize = q.size
            var left: Int = 0
            var right: Int = 0

            for (i in 0 until currentLevelSize) {
                val current = q.poll()
                if (i == 0) left = current.distance
                if (i == currentLevelSize - 1) right = current.distance

                current.node.left?.let { q.add(NodeDistance(it, current.distance * 2)) }
                current.node.right?.let { q.add(NodeDistance(it, current.distance * 2 + 1)) }
            }
            result = maxOf(result, right - left + 1)
        }

        return result
    }
}

