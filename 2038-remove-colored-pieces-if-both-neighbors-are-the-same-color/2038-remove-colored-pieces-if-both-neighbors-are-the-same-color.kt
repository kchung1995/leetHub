class Solution {
    fun winnerOfGame(colors: String): Boolean {
        var aliceScore: Int = 0
        var bobScore: Int = 0

        for (i in 1 until colors.length - 1) {
            if (colors[i - 1] != colors[i] || colors[i] != colors[i + 1]) continue
            when (colors[i]) {
                'A' -> aliceScore++
                'B' -> bobScore++
            }
        }

        return aliceScore - bobScore > 0
    }
}

