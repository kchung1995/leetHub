class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {
        val result = Array(n) { IntArray(n) }

        var rowStart: Int = 0
        var rowEnd = n - 1
        var columnStart: Int = 0
        var columnEnd = n - 1
        var current: Int = 1

        while (rowStart < n && columnStart < n) {
            for (column in columnStart..columnEnd) {
                result[rowStart][column] = current++
            }
            rowStart++

            for (row in rowStart..rowEnd) {
                result[row][columnEnd] = current++
            }
            columnEnd--

            if (rowStart <= rowEnd && columnStart <= columnEnd) {
                for (col in columnEnd downTo columnStart) {
                    result[rowEnd][col] = current++
                }
                rowEnd--

                for (row in rowEnd downTo rowStart) {
                    result[row][columnStart] = current++
                }
                columnStart++
            }
        }

        return result
    }
}

