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
    fun splitListToParts(root: ListNode?, k: Int): Array<ListNode?> {
        var current = root
        var n: Int = 0
        while (current != null) {
            current = current.next
            n++
        }

        val width = n / k
        val rem = n % k

        val result = arrayOfNulls<ListNode>(k)
        current = root
        for (i in 0 until k) {
            val head = ListNode(0)
            var write = head
            for (j in 0 until width + if (i < rem) 1 else 0) {
                write.next = ListNode(current?.`val` ?: 0)
                write = write.next!!
                current = current?.next
            }
            result[i] = head.next
        }
        return result
    }
}

