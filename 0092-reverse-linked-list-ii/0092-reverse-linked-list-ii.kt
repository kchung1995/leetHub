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
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (left == right) return head
        if (head == null) return head

        val reverse: Stack<Int> = Stack<Int>()
        collectReversed(head, 1, reverse, left, right)
        build(head, 1, reverse, left, right)
        return head
    }

    private fun collectReversed(head: ListNode?, iter: Int, reverse: Stack<Int>, left: Int, right: Int) {
        if (head == null) return
        if (left <= iter && iter <= right) reverse.add(head.`val`)
        collectReversed(head.next, iter + 1, reverse, left, right)
    }

    private fun build(head: ListNode?, iter: Int, reverse: Stack<Int>, left: Int, right: Int) {
        if (head == null) return
        if (left <= iter && iter <= right) head.`val` = reverse.pop()
        build(head.next, iter + 1, reverse, left, right)
    }
}

