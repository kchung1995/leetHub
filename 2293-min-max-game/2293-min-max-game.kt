class Solution {
    fun min(a: Int, b: Int): Int {
        if (a <= b) return a
        return b
    }
    
    fun max(a: Int, b: Int): Int {
        if (a >= b) return a
        return b
    }
    
    fun algorithm(nums: IntArray): IntArray {
        if (nums.size == 1) {
            return nums
        }
        val newNums: IntArray = IntArray(nums.size / 2)
        for(i in 0 until newNums.size) {
            when (i % 2) {
                0 -> newNums[i] = min(nums[2 * i], nums[2 * i + 1])
                else -> newNums[i] = max(nums[2 * i], nums[2 * i + 1])
            }
        }
        return algorithm(newNums)
    }
    
    fun minMaxGame(nums: IntArray): Int {
        return algorithm(nums)[0]
    }
}