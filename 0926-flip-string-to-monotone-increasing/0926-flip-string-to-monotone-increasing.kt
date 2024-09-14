class Solution {
    fun minFlipsMonoIncr(s: String): Int {
        var m: Int = 0
        s.forEach { c ->
            if (c == '0') m++
        }
        var result: Int = m
        s.forEach { c ->
            when(c) {
                '0' -> result = minOf(result, --m)
                '1' -> m++
                else -> Unit
            }
        }

        return result
    }
}

