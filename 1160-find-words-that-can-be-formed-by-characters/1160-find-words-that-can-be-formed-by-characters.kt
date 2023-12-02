class Solution {
    fun countCharacters(words: Array<String>, chars: String): Int {
        val charsMap = stringToHashMap(chars)
        
        var result: Int = 0
        for (word in words) {
            val wordMap = stringToHashMap(word)
            var isFormable: Boolean = true

            for (mp in wordMap) {
                if (charsMap.containsKey(mp.key).not() || charsMap[mp.key]!! < mp.value) {
                    isFormable = false
                    break
                }
            }

            if (isFormable) result += word.length
        }

        return result
    }

    private fun stringToHashMap(target: String): HashMap<Char, Int> {
        val result = hashMapOf<Char, Int>()
        for (c in target) {
            result[c] = result.getOrDefault(c, 0) + 1
        }

        return result
    }
}
