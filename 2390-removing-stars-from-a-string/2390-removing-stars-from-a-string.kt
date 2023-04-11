class Solution {
    fun removeStars(s: String): String {
        val stack = Stack<Char>()

        for (i in s) {
            if (i == '*') stack.pop()
            else stack.push(i)
        }

        val result = StringBuilder()
        while (stack.isNotEmpty()) {
            result.append(stack.pop())
        }
        return result.toString().reversed()
    }
}
