class BrowserHistory(homepage: String) {
    private var currentPage: String = homepage
    private val backList = mutableListOf<String>()
    private val forwardList = mutableListOf<String>()

    fun visit(url: String) {
        backList.add(currentPage)
        currentPage = url
        forwardList.clear()
    }

    fun back(steps: Int): String {
        repeat(steps) {
            if (backList.isEmpty()) return currentPage
            forwardList.add(currentPage)
            currentPage = backList.removeAt(backList.lastIndex)
        }
        return currentPage
    }

    fun forward(steps: Int): String {
        repeat(steps) {
            if (forwardList.isEmpty()) return currentPage
            backList.add(currentPage)
            currentPage = forwardList.removeAt(forwardList.lastIndex)
        }
        return currentPage
    }

}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * var obj = BrowserHistory(homepage)
 * obj.visit(url)
 * var param_2 = obj.back(steps)
 * var param_3 = obj.forward(steps)
 */