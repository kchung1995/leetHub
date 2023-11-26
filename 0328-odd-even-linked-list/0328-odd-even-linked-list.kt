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
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) return null
        var odd = head
        var even = head.next
        val evenHead = even

        while (even != null && even.next != null) {
            odd?.next = even?.next;
            odd = odd?.next;
            even?.next = odd?.next;
            even = even?.next;
        }
        odd?.next = evenHead

        return head
    }
}

