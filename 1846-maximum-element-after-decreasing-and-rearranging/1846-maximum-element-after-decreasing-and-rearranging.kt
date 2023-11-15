class Solution {
    fun maximumElementAfterDecrementingAndRearranging(arr: IntArray): Int {
        arr.sort()
        var result: Int = 1
        for (i in 1 until arr.size) {
            if (arr[i] >= result + 1) result++
        }

        return result
    }
}

