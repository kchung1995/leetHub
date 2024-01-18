class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val l = trust.size
        if (l < n - 1) return -1

        val gained = IntArray(n + 1)
        for (t in trust) {
            // t[0] trusts t[1]
            gained[t[0]]--
            gained[t[1]]++
        }

        for (i in 1 .. n) {
            if (gained[i] == n - 1) return i
        }

        return -1
    }
}

