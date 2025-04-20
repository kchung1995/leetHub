class Solution {
    private val ALPHABETS: Int = 26

    fun titleToNumber(columnTitle: String): Int {
        var result: Int = 0
        val maxIndex = columnTitle.length - 1

        for (i in columnTitle.length downTo 1) {
            val idx = i - 1
            val multipler: Int = ALPHABETS.power(maxIndex - i)

            result += multipler * columnTitle[idx].asNumber()
        }

        return result
    }

    private fun Char.asNumber(): Int = this - 'A' + 1

    private fun Int.power(order: Int): Int {
        var result: Int = 1
        for (i in 0 .. order) result *= this
        return result
    }
}

