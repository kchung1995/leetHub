class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        g.sort()
        s.sort()
        val m = g.size
        val n = s.size

        var result: Int = 0
        var currentCookie: Int = 0

        while (result < m && currentCookie < n) {
            if (s[currentCookie] >= g[result]) result++
            currentCookie++
        }

        return result
    }
}

