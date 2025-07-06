class BrowserHistory(homepage: String) {
    private val history = mutableListOf<String>()
    private var currIndex = 0

    init {
        history.add(homepage)
    }

    fun visit(url: String) {
        if (currIndex < history.lastIndex) {
            history.subList(currIndex + 1, history.size).clear()
        }
        history.add(url)
        currIndex = history.lastIndex
    }

    fun back(steps: Int): String {
        currIndex = maxOf(0, currIndex - steps)
        return history[currIndex]
    }

    fun forward(steps: Int): String {
        currIndex = minOf(history.lastIndex, currIndex + steps)
        return history[currIndex]
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * var obj = BrowserHistory(homepage)
 * obj.visit(url)
 * var param_2 = obj.back(steps)
 * var param_3 = obj.forward(steps)
 */
