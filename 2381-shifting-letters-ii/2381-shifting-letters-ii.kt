class Solution {
    companion object {
        private const val A_LOWER: Int = 97
        private const val CHAR_UPPER_LIMIT: Int = 26
    }
    
    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val n = s.length
        val tracking = IntArray(n)
        (0 until n).forEach { tracking[it] = s[it].asInt() }

        shifts.forEach { shift ->
            val start = shift[0]
            val end = shift[1]

            val shiftAs: Int = if (shift[2] == 1) 1 else -1
            (start..end).forEach { sh ->
                tracking[sh] += shiftAs
                if (tracking[sh] >= CHAR_UPPER_LIMIT) tracking[sh] -= CHAR_UPPER_LIMIT
                if (tracking[sh] < 0) tracking[sh] += CHAR_UPPER_LIMIT
            }
        }

        return tracking.toLetters()
    }

    private fun Char.asInt() = this.toInt() - A_LOWER

    private fun Int.asChar() = (this + A_LOWER).toChar()

    private fun IntArray.toLetters(): String {
        val sb = StringBuilder()
        val n = this.size
        (0 until n).forEach {
            sb.append(this[it].asChar())
        }
        
        return sb.toString()
    }
}

