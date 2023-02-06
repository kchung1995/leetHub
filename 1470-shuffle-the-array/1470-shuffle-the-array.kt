class Solution {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val result = IntArray(2*n)
        
        for (i in 0 until n) {
            result[i * 2] = nums[i]
            result[i * 2 + 1] = nums[i + n]
        }
        
        return result
    }
}