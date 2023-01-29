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
    fun treeMaker(n: Int, tree: MutableMap<Int, List<TreeNode>>): List<TreeNode?> {
        val resultTree: List<TreeNode>? = tree.get(n)
        if (resultTree != null) return resultTree
        
        val currentTree: MutableList<TreeNode> = ArrayList()
        if (n == 1) {
            currentTree.add(TreeNode(0))
        }
        val newN = n - 1
        
        for (i in 1..newN step 2) {
            val left: List<TreeNode?> = treeMaker(i, tree)
            val right: List<TreeNode?> = treeMaker(newN - i, tree)
            
            for (leftNode in left) {
                for (rightNode in right) {
                    val rootNode: TreeNode = TreeNode(0)
                    rootNode.left = leftNode
                    rootNode.right = rightNode
                    currentTree.add(rootNode)
                }
            }
        }
                    
        tree[n] =  currentTree
        return currentTree
    }
    
    fun allPossibleFBT(n: Int): List<TreeNode?> {
        return treeMaker(n, mutableMapOf())
    }
}