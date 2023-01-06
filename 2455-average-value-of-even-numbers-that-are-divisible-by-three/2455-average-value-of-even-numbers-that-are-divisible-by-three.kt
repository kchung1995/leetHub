class Solution {
    fun averageValue(nums: IntArray): Int {
        var sumsOfDivisibleByThree = 0
        var elementCount = 0
        
        for (i in nums) {
            if (i % 3 == 0 && i % 2 == 0) {
                sumsOfDivisibleByThree += i
                elementCount++
            }
        }
        
        return if (elementCount == 0) 0
        else sumsOfDivisibleByThree / elementCount
    }
}