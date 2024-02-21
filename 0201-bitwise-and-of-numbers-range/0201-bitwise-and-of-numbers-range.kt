class Solution {
    fun rangeBitwiseAnd(initialLeft: Int, initialRight: Int): Int {
        var left: Int = initialLeft
        var right: Int = initialRight

        var count: Int = 0
        while (left < right) {
            left = left shr 1
            right = right shr 1
            count++
        }

        return left shl count
    }
}

