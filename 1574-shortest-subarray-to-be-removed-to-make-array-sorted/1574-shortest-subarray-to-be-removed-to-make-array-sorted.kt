class Solution {
    fun findLengthOfShortestSubarray(arr: IntArray): Int {
        var right: Int = arr.size - 1
        while (right > 0 && arr[right] >= arr[right - 1]) right--

        var result: Int = right
        var left: Int = 0

        while (left < right && (left == 0 || arr[left - 1] <= arr[left])) {
            while (right < arr.size && arr[left] > arr[right]) right++
            result = minOf(result, right - left - 1)
            left++
        }

        return result
    }
}

