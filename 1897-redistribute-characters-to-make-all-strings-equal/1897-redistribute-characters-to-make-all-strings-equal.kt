class Solution {
    fun makeEqual(words: Array<String>): Boolean {
        val n = words.size
        val charCount: HashMap<Char, Int> = HashMap<Char, Int>()

        for (word in words) {
            for (character in word) {
                charCount[character] = charCount.getOrDefault(character, 0) + 1
            }
        }

        for (character in charCount.keys) {
            if (charCount[character]!! % n != 0) return false
        }
        return true
    }
}

