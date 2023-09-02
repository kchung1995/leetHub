class Solution {
    private lateinit var memo: Array<Int>
    private lateinit var dictionarySet: HashSet<String>

    fun minExtraChar(s: String, dictionary: Array<String>): Int {
        val n = s.length
        memo = List<Int>(n) { -1 }.toTypedArray()
        dictionarySet = HashSet(dictionary.asList())
        return dp(0, n, s)
    }

    private fun dp(start: Int, n: Int, s: String): Int {
        if (start == n) return 0
        if (memo[start] != -1) return memo[start]

        var result = dp(start + 1, n, s) + 1
        for (end in start until n) {
            val current = s.substring(start, end + 1)
            if (dictionarySet.contains(current)) {
                result = minOf(result, dp(end + 1, n, s))
            }
        }
        memo[start] = result
        return result
    }
}

