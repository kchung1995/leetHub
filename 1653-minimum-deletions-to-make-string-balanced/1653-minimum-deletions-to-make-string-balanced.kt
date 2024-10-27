class Solution {
    fun minimumDeletions(s: String): Int {
        val n: Int = s.length
        val countA = IntArray(n)
        val countB = IntArray(n)

        var bCount: Int = 0
        (0 until n).forEach {
            countB[it] = bCount
            if (s[it] == 'b') bCount++
        }

        var aCount: Int = 0
        (n - 1 downTo 0).forEach {
            countA[it] = aCount
            if (s[it] == 'a') aCount++
        }

        var minimumDeletions: Int = n
        (0 until n).forEach {
            minimumDeletions = minOf(minimumDeletions, countA[it] + countB[it])
        }

        return minimumDeletions
    }
}

