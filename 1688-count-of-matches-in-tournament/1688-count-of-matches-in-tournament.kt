class Solution {
    fun numberOfMatches(n: Int): Int {
        var current: Int = n
        var result: Int = 0

        while (current > 1) {
            val currentByHalf = current / 2
            result += currentByHalf
            current = currentByHalf + current % 2
        }

        return result
    }
}

