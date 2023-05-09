class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()
        if (matrix.isEmpty()) return result

        var rowStart = 0
        var rowEnd = matrix.size - 1
        var columnStart = 0
        var columnEnd = matrix[0].size - 1

        while (rowStart <= rowEnd && columnStart <= columnEnd) {
            for (column in columnStart..columnEnd) {
                result.add(matrix[rowStart][column])
            }
            rowStart++

            for (row in rowStart..rowEnd) {
                result.add(matrix[row][columnEnd])
            }
            columnEnd--

            if (rowStart <= rowEnd && columnStart <= columnEnd) {
                for (col in columnEnd downTo columnStart) {
                    result.add(matrix[rowEnd][col])
                }
                rowEnd--

                for (row in rowEnd downTo rowStart) {
                    result.add(matrix[row][columnStart])
                }
                columnStart++
            }
        }

        return result
    }
}

