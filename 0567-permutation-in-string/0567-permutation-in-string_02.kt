class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val first = s1.sortString()
        val n = s1.length
        val m = s2.length

        for (i in 0 .. (m - n)) {
            val target = s2.substring(i, i + n).sortString()
            if (first == target) return true
        }

        return false
    }

    private fun String.sortString() =
        this.toCharArray().sorted().joinToString()
}

