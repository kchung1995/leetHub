class Solution {
    fun simplifyPath(path: String): String {
        val stack = Stack<String>()
        for (next in path.split("/")) {
            when (next) {
                "", "." -> { }
                ".." -> if (stack.isNotEmpty()) stack.pop()
                else -> stack.push(next)
            }
        }

        return "/" + stack.joinToString("/")
    }
}

