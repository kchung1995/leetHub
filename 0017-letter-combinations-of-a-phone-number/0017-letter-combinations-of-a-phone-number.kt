class Solution {
    fun letterCombinations(digits: String): List<String> {
        val result = mutableListOf<String>()
        when (digits.length) {
            0 -> return result
            1 -> return keypad(digits[0])
        }

        val digit = digits[0]
        val left = keypad(digit)
        val right = letterCombinations(digits.substring(1))

        left.forEach { i ->
            right.forEach { j -> 
                val currentResult = j
                result.add(i + j)
            }
        }

        return result
    }


    private fun keypad(num: Char): List<String> = when (num) {
        '1' -> listOf()
        '2' -> listOf("a", "b", "c")
        '3' -> listOf("d", "e", "f")
        '4' -> listOf("g", "h", "i")
        '5' -> listOf("j", "k", "l")
        '6' -> listOf("m", "n", "o")
        '7' -> listOf("p", "q", "r", "s")
        '8' -> listOf("t", "u", "v")
        '9' -> listOf("w", "x", "y", "z")
        else -> emptyList()
    }
}
