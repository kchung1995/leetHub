class Solution {
    fun peakIndexInMountainArray(arr: IntArray): Int {
        var left: Int = 0
        var right: Int = arr.size - 1
        var mid: Int = 0

        while (left <= right) {
            mid = left + (right - left) / 2
            val position = isPeek(arr, mid)
            when (position) {
                0 -> return mid
                1 -> right = mid - 1
                -1 -> left = mid + 1
            }
        }

        return mid
    }

    fun isPeek(arr: IntArray, index: Int): Int {
        if (index == 0) return -1
        if (index == arr.size - 1) return 1

        if (arr[index] > arr[index - 1] && arr[index] > arr[index + 1]) return 0
        if (arr[index] < arr[index - 1]) return 1
        return -1
    }
}

