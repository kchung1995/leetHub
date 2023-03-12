class NumMatrix(matrix: Array<IntArray>) {
    
    private val sum: Array<IntArray> = Array(matrix.size) { IntArray(matrix[0].size) }
    
    init {
        if (matrix.isNotEmpty() && matrix[0].isNotEmpty()) {
            for (i in 0 until matrix.size) {
                sum[i][0] = matrix[i][0]
                for (j in 1 until matrix[0].size) {
                    sum[i][j] = sum[i][j - 1] + matrix[i][j]
                }
            }
            for (j in 0 until matrix[0].size) {
                for (i in 1 until matrix.size) {
                    sum[i][j] += sum[i - 1][j]
                }
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        val topLeft = if (row1 == 0 || col1 == 0) 0 else sum[row1 - 1][col1 - 1]
        val left = if (col1 == 0) 0 else sum[row2][col1 - 1]
        val top = if (row1 == 0) 0 else sum[row1 - 1][col2]
        return sum[row2][col2] - left - top + topLeft
    }

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * var obj = NumMatrix(matrix)
 * var param_1 = obj.sumRegion(row1,col1,row2,col2)
 */