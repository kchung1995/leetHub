class Solution {
    fun minSumOfLengths(arr: IntArray, target: Int): Int {
        val n = arr.size
        val bests = IntArray(n) { Integer.MAX_VALUE }

        var sum: Int = 0
        var start: Int = 0
        var result: Int = Integer.MAX_VALUE
        var currentBest = Integer.MAX_VALUE

        for (i in 0 until n) {
            sum += arr[i]
            while (sum > target) {
                sum -= arr[start]
                start++
            }

            if (sum == target) {
                if (start > 0 && bests[start - 1] != Integer.MAX_VALUE) {
                    result = minOf(result, bests[start - 1] + i - start + 1)
                }
                currentBest = minOf(currentBest, i - start + 1)
            }

            bests[i] = currentBest
        }

        return if (result == Integer.MAX_VALUE) -1 else result
    }
}

