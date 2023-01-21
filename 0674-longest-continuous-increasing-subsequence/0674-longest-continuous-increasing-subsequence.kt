class Solution {
    fun findLengthOfLCIS(nums: IntArray): Int {
        var tempResult: Int = 1
        var result: Int = 0
        
        for (i in 1 until nums.size) {
            if (nums[i] <= nums[i - 1]) {
                result = Math.max(result, tempResult)
                tempResult = 1
            }
            else {
                tempResult++
            }
        }
        result = Math.max(result, tempResult)
        return result
    }
}