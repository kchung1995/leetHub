/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution(val head: ListNode?) {
    fun getRandom(): Int {
        val depth: Int = getDepth(head)
        return getValue(head, (0 until depth).random(), 0)
    }
    
    fun getDepth(currentHead: ListNode?): Int {
        if (currentHead == null) return 0
        return getDepth(currentHead.next) + 1
    }
    
    fun getValue(currentHead: ListNode?, target: Int, current: Int): Int {
        if (currentHead == null) return -1
        if (current == target) return currentHead.`val`
        return getValue(currentHead.next, target, current + 1)
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(head)
 * var param_1 = obj.getRandom()
 */