class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val wordsMap = HashMap<Char, String>()
        val charMap = HashMap<String, Char>()
        val words = s.split("\\s".toRegex()).toTypedArray()
        val n = pattern.length

        if (n != words.size) return false

        for (i in 0 until n) {
            val wordFind = wordsMap.getOrPut(pattern[i]) { words[i] }
            val charFind = charMap.getOrPut(words[i]) { pattern[i] }

            if (wordFind != words[i]) return false
            if (charFind != pattern[i]) return false
        }

        return true
    }
}

