class Solution {
    fun countSubarrays(nums: IntArray, minK: Int, maxK: Int): Long {
        var result: Long = 0
        
        var startIndex: Int = 0
        var lastMinIndex: Int = -1
        var lastMaxIndex: Int = -1
        
        for (i in 0 until nums.size) {
            if (nums[i] < minK || nums[i] > maxK) {
                lastMaxIndex = -1
                lastMinIndex = -1
                startIndex = i + 1
            }

            if (nums[i] == minK) lastMinIndex = i
            if (nums[i] == maxK) lastMaxIndex = i
            
            result += maxOf(0L, (minOf(lastMinIndex, lastMaxIndex) - startIndex + 1).toLong())
        }
        
        return result
    }
}