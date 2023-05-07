class Solution {
    fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        val resultList = mutableListOf<Int>()
        var equalToPivotCount: Int = 0
        val greaterThanPivot: Queue<Int> = LinkedList<Int>()

        for (i in nums) {
            when {
                i < pivot -> resultList.add(i)
                i == pivot -> equalToPivotCount++
                else -> greaterThanPivot.add(i)
            }
        }
        while (equalToPivotCount-- > 0) resultList.add(pivot)
        while (greaterThanPivot.isNotEmpty()) resultList.add(greaterThanPivot.poll())

        return resultList.toIntArray()
    }
}

