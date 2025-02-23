class Solution {
    fun secondHighest(s: String): Int {
        val digits = HashSet<Int>()
        s.forEach { candidate ->
            if (candidate.isDigit()) digits.add(candidate.toString().toInt())
        }

        return if (digits.size < 2) -1
        else {
            val digitsList: List<Int> = ArrayList(digits)
            .sortedDescending()

            digitsList[1]
        }
    }

    private fun Char.isDigit() = '0' <= this && this <= '9'
}

