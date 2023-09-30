class Solution {
    fun countBits(n: Int): IntArray {
        val result = mutableListOf<Int>()
        for (i in 0..n) {
            var current = i
            var count: Int = 0
            while (current > 1) {
                count += (current % 2)
                current /= 2
            }
            count += current
            result.add(count)
        }

        return result.toIntArray()
    }
}
