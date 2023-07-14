class Solution {
    fun longestSubsequence(arr: IntArray, difference: Int): Int {
        val dp = HashMap<Int, Int>()
        var result: Int = 1

        for (i in arr) {
            val previous = dp.getOrDefault(i - difference, 0)
            dp.put(i, previous + 1)
            result = maxOf(result, dp[i]!!)
        }

        return result
    }
}

