class Solution {
    fun removeElement(nums: IntArray, value: Int): Int {
        var pos = 0
        for (i in nums) {
            if (i != value) {
                nums[pos++] = i
            }
        }
        return pos
    }
}