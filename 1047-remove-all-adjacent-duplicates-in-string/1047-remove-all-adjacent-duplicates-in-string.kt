class Solution {
    fun adjacentRemover(s: String): String {
        val stack = Stack<Char>()
        for (i in s.length - 1 downTo 0 ) {
            if (stack.isEmpty() || stack.peek() != s[i]) {
                stack.push(s[i])
            }
            else stack.pop()
        }
        
        val sb = StringBuilder()
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop())
        }
        return sb.toString()
    }
    
    fun removeDuplicates(s: String): String {
        return adjacentRemover(s)
    }
}