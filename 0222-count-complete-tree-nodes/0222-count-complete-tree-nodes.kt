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
    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0

        val depth = depth(root)
        if (depth == 0) return 1

        var left: Int = 1
        var right: Int = Math.pow(2.0, depth.toDouble()).toInt() - 1
        var mid: Int = 0

        while (left <= right) {
            mid = left + (right - left) / 2
            if (nodeExists(mid, depth, root)) {
                left = mid + 1
            }
            else {
                right = mid - 1
            }
        }

        return Math.pow(2.0, depth.toDouble()).toInt() - 1 + left
    }

    private fun depth(startNode: TreeNode): Int {
        var depth: Int = 0
        var currentNode: TreeNode? = startNode
        while (currentNode?.left != null) {
            currentNode = currentNode?.left
            depth++
        }

        return depth
    }

    private fun nodeExists(index: Int, depth: Int, startNode: TreeNode): Boolean {
        var left: Int = 0
        var right: Int = Math.pow(2.0, depth.toDouble()).toInt() - 1
        var mid: Int = 0
        var currentNode: TreeNode? = startNode

        for (i in 0 until depth) {
            mid = left + (right - left) / 2
            if (index <= mid) {
                currentNode = currentNode?.left
                right = mid
            } else {
                currentNode = currentNode?.right
                left = mid + 1
            }
        }

        return currentNode != null
    }
}

