class Solution {
    fun findDuplicate(nums: IntArray): Int {
        val record = mutableSetOf<Int>()
        for (i in nums) {
            if (record.contains(i)) return i
            record.add(i)
        }

        return -1
    }
}
