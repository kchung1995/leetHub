class Solution {
    fun findNumbers(nums: IntArray): Int {
        return nums.map { it.toString() }.filter { it.length % 2 == 0 }.size
    }
}
