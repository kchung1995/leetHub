val ALPHABETS = 26

class TrieNode {
    val children = arrayOfNulls<TrieNode>(ALPHABETS)
    var isWord: Boolean = false
}

class WordDictionary() {
    private val root = TrieNode()

    fun addWord(word: String) {
        var node = root
        for (i in word) {
            val index: Int = i - 'a'
            node.children[index] = node.children[index] ?: TrieNode()
            node = node.children[index]!!
        }
        node.isWord = true
    }

    fun search(word: String): Boolean {
        return searchNode(word, 0, root)
    }
    
    private fun searchNode(word: String, index: Int, node: TrieNode): Boolean {
        if (index == word.length) return node.isWord
        var childChar = word[index]
        val childCharIndex: Int = childChar - 'a'
        when(childChar) {
            '.' -> {
                for (child in node.children) {
                    if (child != null && searchNode(word, index + 1, child)) return true
                }
            }
            else -> {
                val child = node.children[childCharIndex]
                if (child != null && searchNode(word, index + 1, child)) return true
            }
        }
        return false
    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */