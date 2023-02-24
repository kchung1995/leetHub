class Solution {
    fun minimumDeviation(nums: IntArray): Int {
        val set: TreeSet<Int> = TreeSet()
        
        for (i in nums) {
            when (i % 2) {
                1 -> set.add(i * 2)
                else -> set.add(i)
            }
        }
        
        var result: Int = set.last() - set.first()
        while (set.last() % 2 == 0) {
            val current = set.last()
            set.remove(current)
            set.add(current / 2)
            result = minOf(result, set.last() - set.first())
        }
        
        return result
    }
}