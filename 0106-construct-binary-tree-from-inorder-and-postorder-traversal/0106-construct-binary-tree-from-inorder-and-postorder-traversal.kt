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
    var index: Int = 0
    val inorderMap = HashMap<Int, Int>()
    
    fun inorderTraversal(inorder: IntArray, postorder: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) return null
        
        val nodeValue = postorder[index--]
        val inorderNodeIndex = inorderMap.get(nodeValue) ?: 0
        
        val root = TreeNode(nodeValue)
        root.right = inorderTraversal(inorder, postorder, inorderNodeIndex + 1, end)
        root.left = inorderTraversal(inorder, postorder, start, inorderNodeIndex - 1)
        
        return root
    }
    
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        index = inorder.size - 1
        for (i in 0..index) {
            inorderMap.put(inorder[i], i)
        }
        
        return inorderTraversal(inorder, postorder, 0, index)
    }
}