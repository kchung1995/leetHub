class Solution {
    private val result = mutableListOf<List<Int>>()

    fun combine(n: Int, k: Int): List<List<Int>> {
        recursive(1, n, k, mutableListOf<Int>())
        return result
    }

    private fun recursive(start: Int, n: Int, k: Int, current: MutableList<Int>) {
        for (i in start..n) {
            current.add(i)
            when (current.size.compareTo(k)) {
                0 -> result.add(current.toList())
                -1 -> recursive(i + 1, n, k, current)
            }
            current.removeAt(current.size - 1)
        }
    }
}

