class Solution {
    fun firstUniqChar(s: String): Int {
        val charCount = HashMap<Char, Int>()

        for (c in s) {
            charCount[c] = charCount.getOrDefault(c, 0) + 1
        }

        s.forEachIndexed { index, c ->
            if (charCount.getOrDefault(c, 0) == 1) return index
        }

        return -1
    }
}

