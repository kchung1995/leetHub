class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val limit = (matrix.size * matrix[0].size) - 1
        val divisor = matrix[0].size

        var left: Int = 0
        var right: Int = limit
        var mid: Int = -1

        while (left <= right) {
            mid = (left + (right - left) / 2)
            val i = mid / divisor
            val j = mid % divisor

            when {
                matrix[i][j] == target -> return true
                matrix[i][j] < target -> left = mid + 1
                matrix[i][j] > target -> right = mid - 1
            }
        }
        return false
    }
}
