class Solution {
    fun jump(nums: IntArray): Int {
        val result = Array(nums.size) { 0 }
        result[0] = 0
        
        for (i in 0 until nums.size - 1) {
            for (j in 1..nums[i]) {
                if (i + j >= nums.size)
                    continue
                if(result[i + j] == 0)
                    result[i + j] = result[i] + 1
            }
        }
        
        return result[result.size - 1]
    }
}