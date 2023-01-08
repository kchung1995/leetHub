class Solution {
    val result: MutableList<String> = ArrayList()
    
    fun makeParentheses(current: String, n: Int, left: Int, right: Int) {
        if (current.length == n * 2) {
            result.add(current)
            return
        }
        if (current.length == 0) {
            makeParentheses(current + '(', n, left + 1, right)
            return
        }
        if (current.length == n*2 - 1 && right == n - 1) {
            makeParentheses(current + ')', n, left, right + 1)
            return
        }
        if (left < n && current.length != n*2 - 1) {
            makeParentheses(current + '(', n, left + 1, right)
        }
        if (right < n && left > right) {
            makeParentheses(current + ')', n, left, right + 1)
        }
    }
    
    fun generateParenthesis(n: Int): List<String> {
       
        makeParentheses("", n, 0, 0)
        return result
    }
}