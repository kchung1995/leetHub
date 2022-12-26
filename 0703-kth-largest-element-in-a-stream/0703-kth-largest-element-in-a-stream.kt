class KthLargest(k: Int, nums: IntArray) {
    
    val lower = PriorityQueue<Int>()
    val upper = PriorityQueue<Int>()
    val kSize = k
    
    init {
        for (i in 0 until nums.size) {
            upper.add(nums[i])
        }
        
        while(upper.size > k) {
            lower.add(upper.poll())
        }
    }


    fun add(value: Int): Int {
        if (upper.size < kSize) {
            upper.add(value)
            return upper.peek()
        }
        if (value <= upper.peek()) {
            lower.add(value)
            return upper.peek()
        }
        lower.add(upper.poll())
        upper.add(value)
        return upper.peek()
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */