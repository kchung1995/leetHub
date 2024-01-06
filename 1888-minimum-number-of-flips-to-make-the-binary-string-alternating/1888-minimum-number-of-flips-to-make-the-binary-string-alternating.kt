class Solution {
    fun minFlips(s: String): Int {
        val n = s.length
        val count = Array(2) { IntArray(2) }

        for (i in s.indices) {
            count[s[i] - '0'][i % 2]++
        }

        var result: Int = minOf((count[1][0] + count[0][1]), (count[0][0] + count[1][1]))

        for (i in 0 until n) {
            count[s[i] - '0'][i % 2]--
            count[s[i] - '0'][(n + i) % 2]++

            result = minOf(result, (count[1][0] + count[0][1]), (count[0][0] + count[1][1]))
        }

        return result
    }
}

