class Solution {
    fun sortVowels(s: String): String {
        val temps = s.toList().filter { isVowel(it) }.sorted()
        
        var result = StringBuilder()
        var j: Int = 0
        for (i in s) {
            if (isVowel(i)) {
                result.append(temps[j])
                j++
            }
            else result.append(i)
        }

        return result.toString()
    }

    private fun isVowel(c: Char): Boolean {
        val vowels = hashSetOf('a', 'e', 'i', 'o', 'u',
        'A', 'E', 'I', 'O', 'U')
        return vowels.contains(c)
    }
}

