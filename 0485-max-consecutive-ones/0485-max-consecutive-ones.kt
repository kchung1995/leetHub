class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var currentSize = 0
        var maxSize = -1
        
        for(i in nums) {
            if (i == 1) {
                currentSize++
            }
            else {
                maxSize = maxOf(currentSize, maxSize)
                currentSize = 0
            }
        }
        maxSize = maxOf(currentSize, maxSize)
        
        return maxSize
    }
}