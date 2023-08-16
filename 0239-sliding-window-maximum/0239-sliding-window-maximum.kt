class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val dq: Deque<Int> = ArrayDeque()
        val res: MutableList<Int> = ArrayList()

        for (i in 0 until k) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast()
            }
            dq.offerLast(i)
        }
        res.add(nums[dq.peekFirst()])

        for (i in k until nums.size) {
            if (dq.peekFirst() == i - k) {
                dq.pollFirst()
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast()
            }

            dq.offerLast(i)
            res.add(nums[dq.peekFirst()])
        }
        
        return res.toIntArray()
    }
}

