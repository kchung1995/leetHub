class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[0].size) {
                if (matrix[i][j] == target) return true
            }
        }

        return false
    }
}

