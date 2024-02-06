class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val anagrams = HashMap<String, MutableList<String>>()

        for (word in strs) {
            val sorted = word.sorted()
            if (anagrams.containsKey(sorted)) anagrams[sorted]!!.add(word)
            else anagrams[sorted] = mutableListOf(word)
        }

        return anagrams.map {
            it.value.toList()
        }
    }

    private fun String.sorted(): String {
        val arr = this.toCharArray()
        arr.sort()
        return arr.joinToString("")
    }
}

