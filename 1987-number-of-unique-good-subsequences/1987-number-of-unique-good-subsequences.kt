class Solution {
    companion object {
        private const val MOD: Long = 1000000007    
    }

    fun numberOfUniqueGoodSubsequences(binary: String): Int {
        var first: Long = 0
        var second: Long = 0
        var haveCount: Long = 0
        val n = binary.length

        for (i in 0 until n) {
            if (binary[i] == '1') {
                second = (first + second + 1) % MOD
            }
            else {
                first = (first + second) % MOD
                haveCount = 1
            }
        }

        return ((first + second + haveCount) % MOD).toInt()
    }
}

