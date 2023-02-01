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
    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head
        
        val firstNode = head.next
        val secondNode = firstNode.next
        
        firstNode.next = head
        head.next = swapPairs(secondNode)
        
        return firstNode
    }
}