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
    fun detectCycle(head: ListNode?): ListNode? {
        // floyd's cycle detection algorithm
        var slow = head
        var fast = head
        
        while(fast != null && fast.next != null) {
            slow = slow!!.next
            fast = fast!!.next!!.next
            
            if (slow == fast) {
                slow = head
                while(slow != fast) {
                    slow = slow!!.next
                    fast = fast!!.next
                }
                return slow
            }
        }
        
        return null
    }
}