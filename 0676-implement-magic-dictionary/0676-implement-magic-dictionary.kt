class MagicDictionary() {
    private lateinit var wordGroups: Map<Int, List<String>>

    fun buildDict(dictionary: Array<String>) {
        wordGroups = dictionary.groupBy { it.length }
    }

    fun search(searchWord: String): Boolean {
        return wordGroups[searchWord.length]?.any { it isOneLetterDifferentFrom searchWord } == true
    }

    companion object {
        infix fun String.isOneLetterDifferentFrom(target: String)
            = indices.singleOrNull { this[it] != target[it] } != null
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * var obj = MagicDictionary()
 * obj.buildDict(dictionary)
 * var param_2 = obj.search(searchWord)
 */
