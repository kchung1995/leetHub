class Solution {
    fun sumScores(s: String): Long {
        val calculated = calculate(s)
        
        var result: Long = 0
        result += calculated.sumOf { it.toLong() }
        result += s.length

        return result
    }

    private fun calculate(input: String): List<Int> {
        val n = input.length
        val result = IntArray(n)
        var left: Int = 0
        var right: Int = 0

        for (i in 1 until n) {
            if (i > right) {
                right = i
                left = i
                while (right < n && input[right] == input[right - left]) right++
                result[i] = right - left
                right--
            }
            else {
                val k = i - left
                if (result[k] < right - i + 1) result[i] = result[k]
                else {
                    left = i
                    while (right < n && input[right] == input[right - left]) right++
                    result[i] = right - left
                    right--
                }
            }
        }

        return result.toList()
    }
}

