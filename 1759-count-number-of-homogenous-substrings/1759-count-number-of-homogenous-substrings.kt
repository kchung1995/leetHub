class Solution {
    fun countHomogenous(s: String): Int {
        var result: Long = 0
        val MOD: Long = 1000000007
        val sWithPadding = s + ' '

        var currentCharCount: Long = 1
        var previousChar: Char = s[0]
        for (i in 1 until sWithPadding.length) {
            if (previousChar != sWithPadding[i]) {
                result = (result + (currentCharCount * (currentCharCount + 1) / 2)) % MOD
                currentCharCount = 0
            }
            previousChar = sWithPadding[i]
            currentCharCount++
        }

        return result.toInt()
    }
}

