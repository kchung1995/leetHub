class Solution {
    fun letterCasePermutation(s: String): List<String> {
        val result = mutableListOf<String>()
        permutate(result, s.toCharArray(), 0)
        return result
    }

    private fun permutate(result: MutableList<String>, s: CharArray, i: Int) {
        if (i == s.size) {
            result.add(String(s))
            return
        }

        val c = s[i]
        if (Character.isLetter(c)) {
            permutate(result, s, i + 1)
            if (c.isLowerCase()) {
                s[i] = Character.toUpperCase(c)
            }
            else if (c.isUpperCase()) {
                s[i] = Character.toLowerCase(c)
            }
            permutate(result, s, i + 1)
            return
        }
        permutate(result, s, i + 1)
    }

    private fun Char.isLowerCase(): Boolean = 'a' <= this && this <= 'z'

    private fun Char.isUpperCase(): Boolean = 'A' <= this && this <= 'Z'
}

