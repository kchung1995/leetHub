class Solution {
    fun numSpecial(mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size
        val rowCount = IntArray(m)
        val columnCount = IntArray(n)

        for (row in 0 until m) {
            for (column in 0 until n) {
                if (mat[row][column] == 1) {
                    rowCount[row]++
                    columnCount[column]++
                }
            }
        }

        var result = 0
        for (row in 0 until m) {
            for (column in 0 until n) {
                if (mat[row][column] == 1) {
                    if (rowCount[row] == 1 && columnCount[column] == 1) {
                        result++
                    }
                }
            }
        }

        return result
    }
}

