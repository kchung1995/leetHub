class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        val result = IntArray(rowIndex + 1) { 1 }

        for (i in 1 until rowIndex) {
            for (j in 0 until i) {
                result[i - j] += result[i - j - 1]
            }
        }

        return result.asList()
    }
}

