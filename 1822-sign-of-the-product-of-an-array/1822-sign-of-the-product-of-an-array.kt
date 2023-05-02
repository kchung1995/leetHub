class Solution {
    fun arraySign(nums: IntArray): Int {
        var minusCount: Int = 0
        for (i in nums) {
            when {
                i == 0 -> return 0
                i < 0 -> minusCount++
            }
        }
        return when {
            minusCount % 2 == 0 -> 1
            else -> -1
        }
    }
}

