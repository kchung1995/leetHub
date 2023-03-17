class Node{
    var isExist: Boolean = false
    var children: MutableMap<Char, Node> = mutableMapOf()
}

class Trie() {
    private val root: Node = Node()
    
    fun insert(word: String) {
        var node = root
        for (i in word) {
            if (!node.children.containsKey(i)) {
                node.children[i] = Node()
            }
            node = node.children[i]!!
        }
        node.isExist = true
    }

    fun search(word: String): Boolean {
        var node = root
        for (i in word) {
            if (!node.children.containsKey(i)) return false
            node = node.children[i]!!
        }
        return node.isExist
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        for (i in prefix) {
            if (!node.children.containsKey(i)) return false
            node = node.children[i]!!
        }
        return true
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */