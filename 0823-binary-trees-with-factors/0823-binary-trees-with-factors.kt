class Solution {
    fun numFactoredBinaryTrees(arr: IntArray): Int {
        val kMod = 1_000_000_007
        val n = arr.size

        val dp = LongArray(n) { 1 }
        val numToIndex = HashMap<Int, Int>()

        arr.sort()
        for (i in arr.indices) {
            numToIndex[arr[i]] = i
        }

        for (i in 0 until arr.size) {
            for (j in 0 until i) {
                if (arr[i] % arr[j] == 0) {
                    val right = arr[i] / arr[j]
                    if (numToIndex.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[numToIndex[right]!!]) % kMod
                    }
                }
            }
        }

        return (dp.sum() % kMod).toInt()
    }
}
