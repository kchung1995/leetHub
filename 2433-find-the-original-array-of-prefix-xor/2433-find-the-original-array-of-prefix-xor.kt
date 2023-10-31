class Solution {
    fun findArray(pref: IntArray): IntArray {
        val n = pref.size

        val result = IntArray(n)
        result[0] = pref[0]
        for (i in 1 until n) {
            result[i] = pref[i] xor pref[i - 1]
        }

        return result
    }
}
