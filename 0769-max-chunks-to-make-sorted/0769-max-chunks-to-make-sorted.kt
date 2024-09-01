class Solution {
    fun maxChunksToSorted(arr: IntArray): Int {
        var max: Int = 0
        var count: Int = 0
        val n = arr.size

        for (i in 0 until n) {
            max = maxOf(arr[i], max)
            if (max == i) count++
        }

        return count
    }
}

