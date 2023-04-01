class Solution {
    fun hasAlternatingBits(inputN: Int): Boolean {
        var previous = inputN % 2
        var n = inputN
        while (n > 1) {
            n = n shr 1
            if (n % 2 == previous) return false
            previous = n % 2
        }
        return true
    }
}

