class Solution {
    fun numIdenticalPairs(nums: IntArray): Int {
        val numberCounts = HashMap<Int, Int>()
        var result: Int = 0

        for (number in nums) {
            result += numberCounts.getOrDefault(number, 0)
            numberCounts.put(number, numberCounts.getOrDefault(number, 0) + 1)
        }

        return result
    }
}
