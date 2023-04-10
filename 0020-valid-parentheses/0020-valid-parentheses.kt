class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()

        for (i in s) {
            if (isOpeningBracket(i)) stack.push(i)
            else {
                if (stack.isEmpty()) return false
                if (isMatchingBracket(stack.peek(), i)) {
                    stack.pop()
                }
                else return false
            }
        }
        if (stack.isNotEmpty()) return false
        return true
    }

    private fun isOpeningBracket(bracket: Char): Boolean = bracket == '(' || bracket == '{' || bracket == '['

    private fun isClosingBracket(bracket: Char): Boolean = bracket == ')' || bracket == '}' || bracket == ']'

    private fun isMatchingBracket(first: Char, second: Char): Boolean {
        return when {
            first == '(' && second == ')' -> true
            first == '{' && second == '}' -> true
            first == '[' && second == ']' -> true
            else -> false
        }
    }
}
