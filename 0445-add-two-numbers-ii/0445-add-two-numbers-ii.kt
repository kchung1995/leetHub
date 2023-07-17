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
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var temp: ListNode?
        var current = head
        while (current != null) {
            temp = current.next
            current.next = prev
            prev = current
            current = temp
        }
        return prev
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val r1 = reverseList(l1)
        val r2 = reverseList(l2)
        var totalSum = 0
        var carry = 0
        val ans = ListNode(0)
        var current = ans
        var tempR1 = r1
        var tempR2 = r2
        while (tempR1 != null || tempR2 != null) {
            if (tempR1 != null) totalSum += tempR1.`val`
            if (tempR2 != null) totalSum += tempR2.`val`
            current.next = ListNode(totalSum % 10)
            carry = totalSum / 10
            current = current.next!!
            totalSum = carry
            tempR1 = tempR1?.next
            tempR2 = tempR2?.next
        }
        if (carry != 0) current.next = ListNode(carry)
        return reverseList(ans.next)
    }
}
