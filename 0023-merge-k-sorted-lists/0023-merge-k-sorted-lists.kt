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
    fun getLinkedListValue(node: ListNode?, pq: PriorityQueue<Int>) {
        if (node == null) return
        pq.add(node.`val`)
        getLinkedListValue(node.next, pq)
    }
    
    fun makeLinkedList(pq: PriorityQueue<Int>): ListNode? {
        if (pq.isEmpty()) return null
        val node = ListNode(pq.poll())
        node.next = makeLinkedList(pq)
        return node
    }
    
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.size == 0) return null
        var isAllNull = true
        for (i in lists) {
            if (i != null) isAllNull = false
        }
        if (isAllNull) return null
        
        val pq = PriorityQueue<Int>()
        
        for (i in lists) {
            getLinkedListValue(i, pq)
        }
        
        return makeLinkedList(pq)
    }
}