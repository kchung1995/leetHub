class Solution {
    fun getMin(i: Int, j: Int): Int {
        if (i < j) return i
        return j
    }
    
    fun maxSumDivThree(nums: IntArray): Int {
        var sum = 0
        var one = 99999
        var two = 99999
        
        for (i in nums) {
            sum += i
            when {
                i % 3 == 1 -> {
                    getMin(two, one + i)
                    two = getMin(two, one + i)
                    one = getMin(one, i)
                }
                i % 3 == 2 -> {
                    one = getMin(one, two + i)
                    two = getMin(two, i)
                }
            }
        }
        
        var result = 0
        when {
            sum % 3 == 0 -> result = sum
            sum % 3 == 1 -> result = sum - one
            sum % 3 == 2 -> result = sum - two
        }
        
        return result
    }
}