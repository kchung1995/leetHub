class Solution {
    fun sortByBits(arr: IntArray): IntArray {
        val nums = arr.map { it }.toTypedArray()
        val comparator = BitComparator()
        nums.sortWith(comparator)
        return nums.toIntArray()
    }
}

class BitComparator : Comparator<Int> {
    override fun compare(a: Int, b: Int): Int {
        val result = Integer.bitCount(a) - Integer.bitCount(b)
        if (result == 0) return a - b
        return result
    }
}

