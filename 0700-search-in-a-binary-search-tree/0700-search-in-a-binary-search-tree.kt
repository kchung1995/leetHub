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
    
    fun find(current: TreeNode?, `val`: Int): TreeNode? {
        if (current?.`val` == `val`) {
            return current
        }
        if (current?.right != null && current?.`val` < `val`) {
            return find(current.right, `val`)
        }
        if (current?.left != null && current?.`val` > `val`) {
            return find(current.left, `val`)
        }
        return null
    }
    
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        return find(root, `val`)
    }
}