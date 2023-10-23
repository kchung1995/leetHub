class Solution {
    fun isPowerOfFour(n: Int): Boolean {
        if (n <= 0) return false
        return Integer.bitCount(n) == 1 && (n - 1) % 3 == 0
    }
}
