class Solution {
    fun isOperator(op: String): Boolean = op == "+" || op == "-" || op == "*" || op == "/"
    
    fun calculate(a: Int, b: Int, op: String): Int {
        return when(op) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> a / b
            else -> -1
        }
    }
    
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<String>()
        
        for (i in tokens) {
            if (isOperator(i)) {
                val b: Int = stack.pop().toInt()
                val a: Int = stack.pop().toInt()
                stack.push(calculate(a, b, i).toString())
            }
            else {
                stack.push(i)
            }
        }
        
        return stack.pop().toInt()
    }
}