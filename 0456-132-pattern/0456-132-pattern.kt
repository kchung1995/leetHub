class Solution {
    fun find132pattern(nums: IntArray): Boolean {
        val stack = Stack<Int>()
        var third = Integer.MIN_VALUE

        for (i in nums.size - 1 downTo 0) {
            if (nums[i] < third) return true
            
            while (stack.isNotEmpty() && nums[i] > stack.peek()) {
                third = stack.pop()
            }

            stack.push(nums[i])
        }

        return false
    }
}
