class Solution {
    fun zeroFilledSubarray(nums: IntArray): Long {
        var result: Long = 0
        var zeroCount: Int = 0
        var isPreviousZero: Boolean = false
        
        val length = LongArray(nums.size + 1) { 0 }
        for (i in 1..nums.size) {
            length[i] = length[i - 1] + i
        }
        
        for (i in nums) {
            when {
                i == 0 -> {
                    zeroCount++
                    isPreviousZero = true
                }
                i != 0 && isPreviousZero -> {
                    result += length[zeroCount]
                    isPreviousZero = false
                    zeroCount = 0
                }
            }
        }
        
        result += length[zeroCount]
        return result
    }
}
