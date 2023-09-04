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
    private val visitedValue = 9999999

    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) return false
        if (head.next == null) return false
        if (head.`val` == visitedValue) return true

        head.`val` = visitedValue
        return hasCycle(head.next)
    }
}
