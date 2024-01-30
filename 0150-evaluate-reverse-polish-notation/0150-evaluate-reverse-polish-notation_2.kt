class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        
        for (i in tokens) {
            if (isOperator(i)) {
                val b: Int = stack.pop().toInt()
                val a: Int = stack.pop().toInt()
                stack.push(calculate(a, b, i))
            }
            else {
                stack.push(i.toInt())
            }
        }
        
        return stack.pop()
    }

    private fun isOperator(operator: String) = operator in setOf("+", "-", "*", "/")

    private fun calculate(a: Int, b: Int, operator: String) = when (operator) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            "/" -> a / b
            else -> -1
    }
}

