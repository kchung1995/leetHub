/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
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
    fun runner(head: ListNode?): TreeNode? {
        if (head == null) return null
        if (head.next == null) return TreeNode(head.`val`)
        
        var prev: ListNode? = ListNode(-1)
        var slow: ListNode? = head
        var fast: ListNode? = head
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next
            prev = slow
            slow = slow?.next
        }
        prev?.next = null
        
        requireNotNull(slow)
        val treeNode = TreeNode(slow.`val`)
        treeNode.left = runner(head)
        treeNode.right = runner(slow.next)
        
        return treeNode
    }
    
    fun sortedListToBST(head: ListNode?): TreeNode? {
        return runner(head)
    }
}