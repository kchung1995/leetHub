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
    private val list: MutableList<MutableList<Int>> = MutableList(0) { mutableListOf<Int>() }
    
    fun reverseList() {
        for (i in 1 until list.size step 2) {
            list[i] = list[i].reversed().toMutableList()
        }
    }
    
    fun zigzagTraversal(root: TreeNode?, level: Int) {
        if (root == null) return
        if (list.size < level + 1) list.add(mutableListOf<Int>())
        list[level].add(root.`val`)
        
        zigzagTraversal(root.left, level + 1)
        zigzagTraversal(root.right, level + 1)
        return
    }
    
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        zigzagTraversal(root, 0)
        reverseList()
        return list
    }
}