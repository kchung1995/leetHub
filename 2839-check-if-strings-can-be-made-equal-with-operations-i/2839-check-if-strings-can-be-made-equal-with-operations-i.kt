class Solution {
    fun canBeEqual(s1: String, s2: String): Boolean {
        val s1First = swapIfFirstIsBiggerThanSecond(Pair(s1[0], s1[2]))
        val s2First = swapIfFirstIsBiggerThanSecond(Pair(s2[0], s2[2]))
        if (s1First != s2First) return false

        val s1Second = swapIfFirstIsBiggerThanSecond(Pair(s1[1], s1[3]))
        val s2Second = swapIfFirstIsBiggerThanSecond(Pair(s2[1], s2[3]))
        if (s1Second != s2Second) return false
        return true
    }

    private fun swapIfFirstIsBiggerThanSecond(input: Pair<Char, Char>): Pair<Char, Char> {
        if (input.first > input.second) return Pair(input.second, input.first)
        return input
    }
}

