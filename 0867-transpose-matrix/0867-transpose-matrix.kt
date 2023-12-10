class Solution {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        val n = matrix.size
        val m = matrix[0].size

        val result = Array(m) { IntArray (n) }

        for (i in 0 until n) {
            for (j in 0 until m) {
                result[j][i] = matrix[i][j]
            }
        }

        return result
    }
}

