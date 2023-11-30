class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        val frequency = IntArray(26)

        var start: Int = 0
        var maxFrequency: Int = 0
        var longestSubstringLength: Int = 0

        for (end in 0 until s.length) {
            val currentChar = s[end] - 'A'
            frequency[currentChar]++
            maxFrequency = maxOf(maxFrequency, frequency[currentChar])

            val isValid: Boolean = ((end - start + 1 - maxFrequency) <= k)
            if (isValid.not()) {
                val exitChar = s[start] - 'A'
                frequency[exitChar]--
                start++
            }

            longestSubstringLength = end - start + 1
        }

        return longestSubstringLength
    }
}

