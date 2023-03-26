/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun sortList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head
        
        var slow = head
        var fast = head.next
        
        while (fast != null && fast.next != null) {
            slow = slow!!.next
            fast = fast.next!!.next
        }
        
        val mid = slow!!.next
        slow.next = null
        return merge(sortList(head), sortList(mid))
    }
    
    private fun merge(left: ListNode?, right: ListNode?): ListNode? {
        if (left == null) return right
        if (right == null) return left
        
        when (left.`val` < right.`val`) {
            true -> {
                left.next = merge(left.next, right)
                return left
            }
            else -> {
                right.next = merge(left, right.next)
                return right
            }
        }
    }
}
