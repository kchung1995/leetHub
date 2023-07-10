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
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0

        val q: Queue<TreeNode> = LinkedList<TreeNode>()
        q.add(root)

        var result: Int = 1
        while (q.isNotEmpty()) {
            var currentQueueSize = q.size
            while (currentQueueSize > 0) {
                currentQueueSize--

                val current = q.poll()
                if (current == null) continue

                if (current.left == null && current.right == null) return result

                q.add(current.left)
                q.add(current.right)
            }
            result++
        }

        return -1
    }
}

