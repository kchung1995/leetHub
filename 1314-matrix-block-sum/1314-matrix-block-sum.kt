class Solution {
    var m: Int = 0
    var n: Int = 0

    fun matrixBlockSum(mat: Array<IntArray>, k: Int): Array<IntArray> {
        m = mat.size
        n = mat[0].size
        val result = Array(m) { IntArray(n) { 0 } }

        for (i in 0 until m) {
            var sum: Int = 0
            for (j in 0 until n) {
                sum += mat[i][j]
                mat[i][j] = sum + if(i - 1 >= 0) mat[i - 1][j] else 0
            }
        }

        for (i in 0 until m) {
            for (j in 0 until n) {
                val minR = maxOf(-1, i - k - 1)
                val maxR = minOf(m - 1, i + k)
                val minC = maxOf(-1, j - k - 1)
                val maxC = minOf(n - 1, j + k)

                val maxRC = mat[maxR][maxC]
                val minRC = if (minR == -1 || minC == -1) 0 else mat[minR][minC]
                val maxMinRC = if (minC == -1) 0 else mat[maxR][minC]
                val minMaxRC = if (minR == -1) 0 else mat[minR][maxC]

                result[i][j] = maxRC + minRC - maxMinRC - minMaxRC
            }
        }

        return result
    }
}

