class Solution {
    fun rearrangeArray(nums: IntArray): IntArray {
        val positives = nums.filter { it >= 0 }
        val negatives = nums.filter { it < 0 }

        return positives.zip(negatives)
            .flatMap { (p, n) -> listOf(p, n) }
            .toIntArray()
    }
}

