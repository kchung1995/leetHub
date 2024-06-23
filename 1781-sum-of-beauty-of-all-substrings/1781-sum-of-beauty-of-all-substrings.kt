class Solution {
    fun beautySum(s: String): Int {
        val n = s.length
        return (0 .. n - 1).map { i ->
            (i + 1 .. n).map { j ->
                s.substring(i, j).beauty()
            }
        }
        .flatten()
        .sum()
    }

    private fun String.beauty(): Int {
        val frequency = IntArray(26) { 0 }
        for (character in this) {
            frequency[character.code - 'a'.code]++
        }
        val result = frequency.filter { it != 0 }

        return result.maxOrNull()!! - result.minOrNull()!!
    }
}

