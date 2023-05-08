class Solution {
    fun diagonalSum(mat: Array<IntArray>): Int {
        val n = mat.size
        var result: Int = 0

        for (i in 0 until n) {
            val secondary = n - i - 1
            result += mat[i][i]
            if (i != secondary) result += mat[i][secondary]
        }

        return result
    }
}

