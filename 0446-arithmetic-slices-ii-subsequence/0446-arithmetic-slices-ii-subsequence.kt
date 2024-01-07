class Solution {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
         val n = nums.size

         var result: Long = 0
         val numberCount = Array(n) { HashMap<Int, Int>(it) }
         for (i in 0 until n) {
             for (j in 0 until i) {
                 val longDifference: Long = nums[i].toLong() - nums[j].toLong()
                 if (longInIntegerRange(longDifference)) continue

                 val difference = longDifference.toInt()
                 val sum = numberCount[j].getOrDefault(difference, 0)
                 val original = numberCount[i].getOrDefault(difference, 0)

                 numberCount[i][difference] = original + sum + 1
                 result += sum.toLong()
             }
         }

         return result.toInt()
    }

    private fun longInIntegerRange(value: Long): Boolean = value < Integer.MIN_VALUE.toLong() || value > Integer.MAX_VALUE.toLong()
}

