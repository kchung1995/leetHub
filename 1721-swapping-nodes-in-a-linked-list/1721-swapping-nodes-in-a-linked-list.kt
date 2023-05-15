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
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        if (head == null) return head

        val n = getTotalLengthOfNode(head)
        val secondK = n - k + 1

        val front = getFrontNode(head, k, 1)
        val behind = getAndSetBehindNode(head, secondK, 1, front)
        setFrontNode(head, k, 1, behind)

        return head
    }

    private fun getTotalLengthOfNode(head: ListNode?): Int {
        var result: Int = 0
        return when {
            head == null -> 0
            else -> getTotalLengthOfNode(head.next) + 1
        }
    }

    private fun getFrontNode(head: ListNode, target: Int, current: Int): Int {
        if (current == target) return head.`val`
        else return getFrontNode(head.next, target, current + 1)
    }

    private fun setFrontNode(head: ListNode, target: Int, current: Int, targetValue: Int) {
        if (current == target) {
            head.`val` = targetValue
            return
        }
        else return setFrontNode(head.next, target, current + 1, targetValue)
    }

    private fun getAndSetBehindNode(head: ListNode, target: Int, current: Int, targetValue: Int): Int {
        if (current == target) {
            val behindValue = head.`val`
            head.`val` = targetValue
            return behindValue
        }
        else return getAndSetBehindNode(head.next, target, current + 1, targetValue)
    }
}

