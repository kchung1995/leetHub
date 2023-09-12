class Solution {
    fun minDeletions(s: String): Int {
        val n = s.length
        if (n == 1) return 1

        val appearCount = IntArray(26) { 0 }
        for (ch in s) {
            appearCount[convertCharToInt(ch)]++
        }
        appearCount.sort()

        var maxCount = appearCount[25]
        var result: Int = 0
        for (i in 25 downTo 0) {
            val currentCount = appearCount[i]

            if (currentCount == 0) continue
            if (currentCount < maxCount) maxCount = currentCount
            else if (currentCount > maxCount) result += (currentCount - maxCount)
            if (maxCount > 0) maxCount--
        }

        return result
    }

    private fun convertCharToInt(char: Char): Int = char - 'a'
}

