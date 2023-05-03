class Solution {
    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val answer1 = HashSet<Int>()
        val answer2 = HashSet<Int>()

        for (i in nums1) {
            answer2.add(i)
        }
        for (i in nums2) {
            answer1.add(i)
            answer2.remove(i)
        }
        for (i in nums1) {
            answer1.remove(i)
        }

        return listOf(answer2.toList(), answer1.toList())
    }
}

