class Solution {
    fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
        
        var result = 0
        val team = Array(scores.size){ idx -> Pair(ages[idx], scores[idx])}
        team.sortWith(compareBy({ it.first },{it.second }))
        
        val dp = Array(scores.size) { 0 }
        
        for (i in 0 until team.size) {
            dp[i] = team[i].second
            for (j in i - 1 downTo 0) {
                if (team[i].second < team[j].second) continue
                dp[i] = maxOf(dp[i], dp[j] + team[i].second)
            }
            result = maxOf(result, dp[i])
        }
        
        return result
    }
}