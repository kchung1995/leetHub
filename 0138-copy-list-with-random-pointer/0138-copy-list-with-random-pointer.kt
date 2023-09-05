/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution {
    fun copyRandomList(head: Node?): Node? {
        var current = head
        
        while (current != null) {
            val newNode = Node(current.`val`)
            newNode.next = current.next
            current.next = newNode
            current = current.next?.next
        }
        
        current = head
        while (current != null) {
            if (current.random != null) {
                current.next?.random = current.random?.next
            }
            current = current.next?.next
        }
        
        current = head
        val dummy = Node(0)
        var prev: Node? = dummy
        
        while (current != null) {
            prev?.next = current.next
            current.next = current.next?.next
            prev = prev?.next
            current = current.next
        }
        
        return dummy.next
    }
}

