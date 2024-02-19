class Solution {
    fun isPowerOfTwo(n: Int): Boolean {
        if (n == 0) return false
        val l = n.toLong()
        return (l and (l - 1)) == 0L
    }
}

