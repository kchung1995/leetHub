class Solution {
    fun countBits(n: Int): IntArray {
        val result = mutableListOf<Int>()

        for (i in 0..n) {
            result.add(Integer.toBinaryString(i).count { it == '1' })
        }

        return result.toIntArray()
    }
}

