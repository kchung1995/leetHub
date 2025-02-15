class Solution {
    fun reformat(s: String): String {
        val alphabets = mutableListOf<Char>()
        val digits = mutableListOf<Char>()

        s.forEach { cand ->
            when {
                cand.isAlphabet() -> alphabets.add(cand)
                cand.isDigit() -> digits.add(cand)
                else -> throw IllegalArgumentException("?")
            }
        }

        if (abs(alphabets.size - digits.size) > 1) return ""

        val result = if (alphabets.size >= digits.size) joinTwoLists(alphabets, digits)
        else joinTwoLists(digits, alphabets)

        return result.joinToString(separator = "")
    }

    private fun Char.isAlphabet() = 'a' <= this && this <= 'z'

    private fun Char.isDigit() = '0' <= this && this <= '9'

    private fun joinTwoLists(larger: List<Char>, smaller: List<Char>): List<Char> {
        val result = mutableListOf<Char>()
        for (i in 0 until larger.size) {
            result.add(larger[i])
            if (smaller.size > i) result.add(smaller[i])
        }
        return result
    }
}

