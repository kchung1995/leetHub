class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        // pq holds k elements
        val pq = PriorityQueue<Int>()
        
        for (i in nums) {
            if (pq.size < k)
                pq.add(i)
            else {
                if (i >= pq.peek()) {
                    pq.add(i)
                    pq.poll()
                }
            }
        }
        return pq.peek()
    }
}