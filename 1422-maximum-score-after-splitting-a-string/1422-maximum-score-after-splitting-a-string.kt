class Solution {
    fun maxScore(s: String): Int {
        var ones: Int = s.count {it == '1'} 
        var zeros: Int = 0

        var result: Int = 0
        for (i in 0 until s.length - 1) {
            if (s[i] == '1') ones--
            else zeros++

            result = maxOf(result, zeros + ones)
        }

        return result
    }
}

