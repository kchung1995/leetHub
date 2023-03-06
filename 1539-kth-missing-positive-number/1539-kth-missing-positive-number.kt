class Solution {
    fun findKthPositive(arr: IntArray, k: Int): Int {
        // binary search
        var left: Int = 0
        var right: Int = arr.size
        var mid: Int = -1
        
        while (left < right) {
            mid = left + ((right - left) / 2)
            // difference between current index and current number at the index
            if (arr[mid] - mid >= k + 1)
                right = mid
            else
                left = mid + 1
        }
        
        return left + k
    }
}
