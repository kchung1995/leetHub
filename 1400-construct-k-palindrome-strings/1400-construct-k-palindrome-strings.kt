class Solution {
    fun canConstruct(s: String, k: Int): Boolean {
        val n = s.length
        var odd: Int = 0
        val count = IntArray(26)

        for (i in 0 until n) {
            val index: Int = (s[i] - 'a')
            count[index] = count[index] xor 1
            odd += if (count[index] > 0) 1 else - 1
        }

        return odd <= k && k <= n
    }
}

