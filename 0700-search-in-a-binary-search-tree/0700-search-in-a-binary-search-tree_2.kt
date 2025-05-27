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
    fun searchBST(root: TreeNode?, target: Int): TreeNode? {
        var result: TreeNode? = null
        if (root == null) return null
        if (root.`val` == target) return root

        var currentNode: TreeNode = root
        while(true) {
            if (currentNode.left == null && currentNode.right == null) break
            if (currentNode.left == null) {
                currentNode = currentNode.right
            }
            else if (currentNode.right == null) {
                currentNode = currentNode.left
            }
            else {
                if (target < currentNode.`val`) currentNode = currentNode.left
                else if (target > currentNode.`val`) currentNode = currentNode.right
            }
            if (currentNode.`val` == target) {
                result = currentNode
                break
            }
        }

        return result
    }
}

