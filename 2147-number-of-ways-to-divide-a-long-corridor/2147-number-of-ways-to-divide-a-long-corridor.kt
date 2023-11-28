class Solution {
    private val MOD = 1000000007

    fun numberOfWays(corridor: String): Int {
        val chairIndexes = mutableListOf<Int>()
        val n = corridor.length
        (0 until n).forEach {
            if (corridor[it] == 'S') chairIndexes.add(it)
        }

        // if (n == 0 || n % 2 == 1) return 0

        val count = Array(n + 1) { IntArray(3) { 0 } }
        count[n][2] = 1

        for (i in n - 1 downTo 0) {
            if (corridor[i] == 'S') {
                count[i][0] = count[i + 1][1];
                count[i][1] = count[i + 1][2];
                count[i][2] = count[i + 1][1];
            }
            else {
                count[i][0] = count[i + 1][0];
                count[i][1] = count[i + 1][1];
                count[i][2] = (count[i + 1][0] + count[i + 1][2]) % MOD;
            }
        }

        return count[0][0]
    }
}

