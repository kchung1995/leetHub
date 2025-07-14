class Solution {
    fun smallestRepunitDivByK(k: Int): Int {
        var remainder: Int = 0
        for (nLength in 1 .. k) {
            remainder = (remainder * 10 + 1) % k
            if (remainder == 0) return nLength
        }

        return -1
    }
}

