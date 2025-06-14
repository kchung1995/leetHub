class Solution {
    fun divisorSubstrings(num: Int, k: Int): Int {
        var result: Int = 0

        val numString = num.toString()
        for (i in 0 .. numString.length - k) {
            val candidate = numString.substring(i, i + k).toInt()
            if (candidate == 0) continue
            if (num % candidate == 0) result++
        }

        return result
    }
}

