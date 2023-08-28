class MyStack() {

    var q1: Queue<Int> = LinkedList<Int>()
    var q2: Queue<Int> = LinkedList<Int>()
    var currentTop: Int = -1

    fun push(x: Int) {
        q1.add(x)
        currentTop = x
    }

    fun pop(): Int {
        while (q1.size > 1) {
            currentTop = q1.poll()
            q2.add(currentTop)
        }
        val result = q1.poll()
        q1 = q2.also { q2 = q1 }

        return result
    }

    fun top(): Int = currentTop

    fun empty(): Boolean = q1.isEmpty() && q2.isEmpty()

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
