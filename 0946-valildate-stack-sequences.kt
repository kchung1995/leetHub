class Solution {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        var pushedIndex: Int = 0
        var poppedIndex: Int = 0
        val stack = Stack<Int>()
        val n = pushed.size

        while (pushedIndex >= poppedIndex && pushedIndex < n) {
            stack.push(pushed[pushedIndex])
            pushedIndex++

            while(stack.isNotEmpty() && stack.peek() == popped[poppedIndex]) {
                stack.pop()
                poppedIndex++
            }
        }

        if (poppedIndex != pushedIndex) return false
        return true
    }
}

