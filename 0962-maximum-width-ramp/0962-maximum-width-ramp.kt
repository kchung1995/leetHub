class Solution {
    fun maxWidthRamp(nums: IntArray): Int {
        val n = nums.size
        var currentMaxWidth = 0
        val s = Stack<Int>()

        for (i in 0 until n) {
            if (s.isEmpty() || nums[s.peek()] > nums[i]) s.add(i)
        }
        for (i in n - 1 downTo currentMaxWidth + 1) {
            while (s.isNotEmpty() && nums[s.peek()] <= nums[i]) {
                currentMaxWidth = maxOf(currentMaxWidth, i - s.pop())
            }
        }

        return currentMaxWidth
    }
}

