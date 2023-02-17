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
    fun treeTraversalDfs(root: TreeNode?, nums: MutableList<Int>) {
        if (root == null) return
        nums.add(root.`val`)
        treeTraversalDfs(root.left, nums)
        treeTraversalDfs(root.right, nums)
        return
    }
    
    fun minDiffInBST(root: TreeNode?): Int {
        val nums = mutableListOf<Int>()
        treeTraversalDfs(root, nums)
        nums.sort()
        
        var result: Int = 100001
        for (i in 0 until nums.size - 1) {
            result = minOf(result, nums[i+ 1] - nums[i])
        }
        
        return result
    }
}