class Solution {
    fun rearrangeCharacters(s: String, target: String): Int {
        val frequencyS = IntArray(26) { 0 }
        val frequencyTarget = IntArray(26) { 0 }

        stringFrequencyCount(s, frequencyS)
        stringFrequencyCount(target, frequencyTarget)

        var result: Int = Integer.MAX_VALUE
        for (ch in target) {
            val compareTo = frequencyS[ch - 'a'] / frequencyTarget[ch - 'a']
            result = minOf(result, compareTo)
        }

        return result
    }

    private fun stringFrequencyCount(target: String, to: IntArray) {
        for (ch in target) {
            to[ch - 'a']++
        }
    }
}

