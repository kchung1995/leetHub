class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        for (i in 0 until numRows) {
            if (i == 0) {
                result.add(listOf(1))
                continue
            }
            if (i == 1) {
                result.add(listOf(1, 1))
                continue
            }
            val current = mutableListOf<Int>()
            for (j in 0..i) {
                when (j) {
                    0 -> current.add(result[i - 1][j])
                    i -> current.add(result[i - 1][j - 1])
                    else -> current.add(result[i - 1][j - 1] + result[i - 1][j])
                }
            }
            result.add(current.toList())
        }

        return result.toList()
    }
}

