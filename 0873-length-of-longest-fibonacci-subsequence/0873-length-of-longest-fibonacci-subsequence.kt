class Solution {
    fun lenLongestFibSubseq(arr: IntArray): Int {
        val n = arr.size
        val index = (0 until n).map{ arr[it] to it }.toMap()
        val longest = hashMapOf<Int, Int>()
        var result: Int = 0

        for (k in 0 until n) {
            for (j in 0 until k) {
                val i = index.getOrDefault(arr[k] - arr[j], -1)
                if (i >= 0 && i < j) {
                    val current = longest.getOrDefault(i * n + j, 2) + 1
                    longest[j * n + k] = current
                    result = maxOf(result, current)
                }
            }
        }

        return if (result >= 3) result else 0
    }
}

