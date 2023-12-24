class Solution {
    fun minOperations(s: String): Int {
        var one: Int = 0
        var two: Int = 0

        for (i in s.indices) {
            when (i % 2) {
                0 -> if (s[i] == '0') two++ else one++
                1 -> if (s[i] == '1') two++ else one++
            }
        }

        return minOf(one, two)
    }
}

