class Solution {
    fun longestString(x: Int, y: Int, z: Int): Int {
        val result = minOf(x, y)
        if (x == y) return (result * 2 + z) * 2
        return (result * 2 + z + 1) * 2
    }
}

