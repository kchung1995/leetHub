class Solution {
    fun smallestEvenMultiple(n: Int): Int {
        if (n % 2 == 0) return n
        return n * 2
    }
}