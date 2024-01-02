class Solution {
    fun findMatrix(nums: IntArray): List<List<Int>> {
        val n = nums.size
        val count = IntArray(n + 1)

        val result = mutableListOf(mutableListOf<Int>())
        for (num in nums) {
            if (count[num] >= result.size) result.add(mutableListOf<Int>())
            result[count[num]].add(num)
            count[num]++
        }

        return result
    }
}

