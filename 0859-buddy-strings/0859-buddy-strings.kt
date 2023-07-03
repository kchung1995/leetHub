class Solution {
    fun buddyStrings(s: String, goal: String): Boolean {
        if (s.length != goal.length) return false
        if (s == goal) return verifyIfTwoStringsAreEqual(s, goal)

        var first: Int = -1
        var second: Int = -1
        for (i in 0 until s.length) {
            if (s[i] != goal[i]) {
                when {
                    first == -1 -> first = i
                    second == -1 -> second = i
                    else -> return false
                }
            }
        }
        if (second == -1) return false

        return s[first] == goal[second] && s[second] == goal[first]
    }

    private fun verifyIfTwoStringsAreEqual(s: String, goal: String): Boolean {
        val frequency = IntArray(26) { 0 }
        for (i in s) {
            frequency[i - 'a']++
            if (frequency[i - 'a'] == 2) return true
        }
        return false
    }
}

