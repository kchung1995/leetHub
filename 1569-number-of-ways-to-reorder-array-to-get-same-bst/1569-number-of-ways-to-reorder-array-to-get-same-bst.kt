class Solution {
    private val MOD: Long = 1000000007

    fun numOfWays(nums: IntArray): Int {
        val m = nums.size
        val table = Array(m) { LongArray(m) { 0 } }

        for (i in 0 until m) {
            table[i][0] = 1
            table[i][i] = 1
        }
        for (i in 2 until m) {
            for (j in 1 until i) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % MOD
            }
        }

        val numsList = nums.toList()
        return ((dfs(numsList, table) - 1) % MOD).toInt()
    }

    private fun dfs(nums: List<Int>, table: Array<LongArray>): Long {
        val m = nums.size
        if (m < 3) return 1
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        for (i in 1 until m) {
            if (nums[i] < nums[0]) left.add(nums[i])
            else right.add(nums[i])
        }

        val leftWays: Long = dfs(left, table) % MOD
        val rightWays: Long = dfs(right, table) % MOD
        val product = (leftWays * rightWays) % MOD

        return (product * table[m - 1][left.size]) % MOD
    }
}

