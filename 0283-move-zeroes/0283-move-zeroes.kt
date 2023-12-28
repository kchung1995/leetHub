class Solution {
    fun moveZeroes(nums: IntArray): Unit {
         val n = nums.size

         for (i in 0 until n - 1) {
             if (nums[i] != 0) continue

             for (j in i + 1 until n) {
                 if (nums[j] != 0) {
                     nums[i] = nums[j].also { nums[j] = nums[i] }
                     break
                 }
             }
         }

         return
    }
}

