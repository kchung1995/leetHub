class Solution {
    fun equalPairs(grid: Array<IntArray>): Int {
        val n = grid.size
        val rows = HashMap<String, Int>()
        val columns = HashMap<String, Int>()

        for (i in 0 until n) {
            val row = convertIntoDigitsRow(grid[i])
            if (rows.containsKey(row)) rows[row] = rows[row]!! + 1 else rows.put(row, 1)
            val column = convertIntoDigitsColumn(i, grid)
            if (columns.containsKey(column)) columns[column] = columns[column]!! + 1 else columns.put(column, 1)
        }

        var result: Int = 0
        for (row in rows.keys) {
            if (columns.containsKey(row)) {
                result += columns[row]!!
                rows[row] = rows[row]!! - 1
            }
        }
        for (column in columns.keys) {
            if (rows.containsKey(column) && rows[column]!! > 0) {
                result += maxOf(columns[column]!!, rows[column]!!)
            }
        }

        return result
    }

    private fun convertIntoDigitsRow(row: IntArray): String {
        val sb = StringBuilder()
        row.forEach { sb.append("${it},") }
        return sb.toString()
    }

    private fun convertIntoDigitsColumn(columnNumber: Int, grid: Array<IntArray>): String {
        val sb = StringBuilder()
        grid.map { it[columnNumber] }.forEach { sb.append("${it},") }
        return sb.toString()
    }
}

