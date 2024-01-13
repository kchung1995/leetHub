class Solution {
    fun minSteps(s: String, t: String): Int {
        val n = s.length
        val alphabetCount: IntArray = IntArray(26) { 0 }
        for (i in 0 until n) {
            alphabetCount[t[i] - 'a']++
            alphabetCount[s[i] - 'a']--
        }

        val result = (0 until 26).map {
            maxOf(0, alphabetCount[it])
        }.sum()

        return result
    }
}

