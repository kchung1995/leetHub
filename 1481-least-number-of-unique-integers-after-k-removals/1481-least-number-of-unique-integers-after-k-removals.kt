class Solution {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        val nums = HashMap<Int, Int>()
        for (i in arr) {
            nums.put(i, nums.getOrDefault(i, 0) + 1)
        }

        val numValues = nums.values.toList().sorted()
        val v = numValues.size
        var removedCount: Int = 0
        for (i in 0 until v) {
            removedCount += numValues[i]
            if (removedCount > k) return v - i
        }

        return 0
    }
}

