class Solution {
    fun findNumbers(nums: IntArray): Int {
        var result = 0
        
        for (i in nums) {
            if (i.toString().length % 2 == 0) {
                result++
            }
        }
        
        return result
    }
}