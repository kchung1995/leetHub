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

class FindElements(root: TreeNode?) {
    private val valSet: MutableSet<Int> = HashSet()
    
    init {
        val queue: Queue<Pair<TreeNode, Int>> = LinkedList()
        root?.let { queue.add(Pair(it, 0)) }
        
        while (queue.isNotEmpty()) {
            val (n, nValue) = queue.poll()
            n.`val` = nValue
            valSet.add(nValue)
            
            n.left?.let { queue.add(Pair(it, 2 * nValue + 1)) }
            n.right?.let { queue.add(Pair(it, 2 * nValue + 2)) }
        }
    }
    
    fun find(target: Int): Boolean {
        return valSet.contains(target)
    }
}


/**
 * Your FindElements object will be instantiated and called as such:
 * var obj = FindElements(root)
 * var param_1 = obj.find(target)
 */
