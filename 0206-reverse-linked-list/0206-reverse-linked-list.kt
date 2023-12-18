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
    val q: Stack<Int> = Stack<Int>()

    fun reverseList(head: ListNode?): ListNode? {
        traverseLinkedList(head)
        if (q.isEmpty()) return null
        val result = ListNode(q.pop())
        constructLinkedList(result)
        return result
    }

    private fun traverseLinkedList(head: ListNode?) {
        if (head == null) return
        q.add(head.`val`)
        traverseLinkedList(head.next)
    }

    private fun constructLinkedList(head: ListNode?) {
        if (q.isEmpty()) return
        head!!.next = ListNode(q.pop())
        constructLinkedList(head.next)
    }
}

