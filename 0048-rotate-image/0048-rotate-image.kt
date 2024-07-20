class Solution {
    private var n = -1;

    fun rotate(matrix: Array<IntArray>): Unit {
        n = matrix.size
        transpose(matrix)
        reflect(matrix)
    }

    private fun transpose(matrix: Array<IntArray>) {
        require(n != -1)
        for (i in 0 until n) {
            for (j in i + 1 until n) {
                matrix[i][j] = matrix[j][i].also { matrix[j][i] = matrix[i][j]}
            }
        }
    }
    
    private fun reflect(matrix: Array<IntArray>) {
        require(n != -1)
        for (i in 0 until n) {
            for (j in 0 until n / 2) {
                matrix[i][j] = matrix[i][n - j - 1].also { matrix[i][n - j - 1] = matrix[i][j]}
            }
        }
    }
}

