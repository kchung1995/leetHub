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
    fun pairSum(head: ListNode?): Int {
        val nums = mutableListOf<Int>()
        var currentHead = head
        while (currentHead != null) {
            nums.add(currentHead.`val`)
            currentHead = currentHead.next
        }

        val n = nums.size
        var result: Int = 0
        for (i in 0 until n / 2) {
            result = maxOf(result, nums[i] + nums[n - i - 1])
        }

        return result
    }
}

