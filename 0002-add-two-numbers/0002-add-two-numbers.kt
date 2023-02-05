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
    fun addNext(l1: ListNode?, l2: ListNode?, tenth: Int): ListNode? {
        // end condition
        if (l1 == null && l2 == null && tenth == 0)
            return null
        
        // add each node's value; if null, add zero. add previous tens place.
        val sum = (l1?.`val` ?:0) + (l2?.`val` ?:0) + tenth
        
        // recursive approach
        val current = ListNode(sum % 10)
        current.next = addNext(l1?.next, l2?.next, sum / 10)
        
        return current
    }
    
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        
        return addNext(l1, l2, 0)
    }
}