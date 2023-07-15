class Solution {
    fun maxValue(events: Array<IntArray>, k: Int): Int {
        events.sortBy { it[0] }
        val dp = Array(k + 1) { IntArray(events.size) { - 1 } }
        return dfs(0, 0, -1, dp, events, k)
    }

    private fun dfs(current: Int, count: Int, previousEndingTime: Int, dp: Array<IntArray>, events: Array<IntArray>, k: Int): Int {
        when {
            current == events.size || count == k -> return 0
            previousEndingTime >= events[current][0] -> return dfs(current + 1, count, previousEndingTime, dp, events, k)
            dp[count][current] != -1 -> return dp[count][current]
        }

        val result = maxOf(
            dfs(current + 1, count, previousEndingTime, dp, events, k),
            dfs(current + 1, count + 1, events[current][1], dp, events, k) + events[current][2]
        )
        dp[count][current] = result
            
        return result
    }
}

