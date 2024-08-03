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
    private var currentListOne: ListNode? = null
    private var currentListTwo: ListNode? = null

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        currentListOne = list1
        currentListTwo = list2

        // initialise
        val result = judgeBetweenTwoListNodes(list1, list2)
        var currentResult = result

        while (currentListOne != null || currentListTwo != null) {
            currentResult!!.next = judgeBetweenTwoListNodes(currentListOne, currentListTwo)
            currentResult = currentResult.next
        }


        return result
    }

    private fun judgeBetweenTwoListNodes(n1: ListNode?, n2: ListNode?): ListNode? {
        return when {
            (n1 == null && n2 == null) -> null
            (n1 != null && n2 == null) -> {
                val result = n1
                currentListOne = n1.next
                result
            }

            (n1 == null && n2 != null) -> {
                val result = n2
                currentListTwo = n2.next
                result
            }

            (n1 != null && n2 != null) -> {
                if (n1.`val` <= n2.`val`) {
                    val result = n1
                    currentListOne = n1.next
                    result
                } else {
                    val result = n2
                    currentListTwo = n2.next
                    result
                }
            }

            else -> throw IllegalStateException()
        }
    }
}

