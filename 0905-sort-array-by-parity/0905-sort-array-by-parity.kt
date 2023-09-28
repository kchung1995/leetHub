class Solution {
    fun sortArrayByParity(nums: IntArray): IntArray = nums.sortedBy { it.isOdd() }.toIntArray()

    private fun Int.isOdd() = this % 2 != 0
}
