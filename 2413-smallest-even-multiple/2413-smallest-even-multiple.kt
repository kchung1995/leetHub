class Solution {
    fun smallestEvenMultiple(n: Int) = when (n % 2 == 0) {
        true -> n
        false -> n * 2
    }
}