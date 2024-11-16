class Solution {
    fun rotateString(s: String, goal: String): Boolean {
        if (s.length != goal.length) return false
        val sps = s + s
        return sps.contains(goal)
    }
}

