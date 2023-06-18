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
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var current: ListNode? = head
        var next: ListNode? = null
        var prev: ListNode? = null
        var count: Int = 0

        while (current != null && count < k) {
            next = current.next
            current.next = prev
            prev = current
            current = next
            count++
        }

        if (count != k) {
            var temp: ListNode? = prev
            prev = null
            while (temp != null) {
                next = temp.next
                temp.next = prev
                prev = temp
                temp = next
            }
            return prev
        }

        if (next != null) {
            val remaining = reverseKGroup(next, k)
            head!!.next = remaining
        }
        return prev
    }
}

