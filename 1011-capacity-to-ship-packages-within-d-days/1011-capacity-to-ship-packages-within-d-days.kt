class Solution {
    fun isRightCondition(weights: IntArray, mid: Int, days: Int): Boolean {
        var currentDays: Int = 1
        var currentSum: Int = 0
        
        for (i in weights) {
            currentSum += i
            if (currentSum > days) {
                currentSum = i
                currentDays++
            }
        }
        if (currentDays > mid) return false
        return true
    }
    
    fun binarySearch(weights: IntArray, days: Int): Int {
        var start: Int = -1
        var end: Int = 0
        var mid: Int = -1
        
        for (i in weights) {
            start = maxOf(start, i)
            end += i
        }
        
        while (start < end) {
            mid = start + ((end - start) / 2)
            if (isRightCondition(weights, days, mid))
                end = mid
            else start = mid + 1
        }
        
        return start
    }
    
    fun shipWithinDays(weights: IntArray, days: Int): Int {
        return binarySearch(weights, days)
    }
}