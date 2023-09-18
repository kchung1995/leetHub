data class Row(val soldiers: Int, val index: Int)

class Solution {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val m = mat.size
        val n = mat[0].size

        val list = mat.mapIndexed { index, row ->
            val soldiers = numberOfSoldiers(row, m, n)
            Row(soldiers, index)
        }.sortedWith(
            compareBy<Row> { it.soldiers }.thenBy { it.index }
        )

        val result = (0 until k).map {
            list[it].index
        }
        return result.toIntArray()
    }

    private fun numberOfSoldiers(row: IntArray, m: Int, n: Int): Int {
        var left = 0
        var right = n - 1
        var mid: Int = -1

        if (row[0] == 0) return 0

        while (left <= right) {
            mid = (left + (right - left) / 2)
            if (row[mid] == 1) {
                if (mid == n - 1) return n
                if (row[mid + 1] == 0) return mid + 1
                left = mid + 1
            }
            else {
                right = mid - 1
            }
        }

        return mid + 1
    }
}

