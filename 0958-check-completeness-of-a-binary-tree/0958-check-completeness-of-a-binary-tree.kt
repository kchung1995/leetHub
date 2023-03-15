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
    fun bfs(root: TreeNode): Boolean {
        val q: Queue<TreeNode> = LinkedList<TreeNode>()
        q.add(root)
        var isOnlyLeaf = false
        
        while(q.isNotEmpty()) {
            var cnt = q.size
            while(cnt > 0) {
                val currentNode = q.poll()
                val left = currentNode.left
                val right = currentNode.right
                if (left == null && right != null) return false
                if (isOnlyLeaf && (left != null || right != null)) return false
                if (left != null) q.add(left)
                if (right != null) q.add(right)
                if (left == null || right == null) isOnlyLeaf = true
                cnt--
            }
        }
        
        return true
    }
    
    fun isCompleteTree(root: TreeNode?): Boolean {
        if (root == null) return true
        return bfs(root)
    }
}