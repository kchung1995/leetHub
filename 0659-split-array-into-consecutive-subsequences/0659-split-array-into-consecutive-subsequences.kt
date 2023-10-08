class Solution {
    fun isPossible(nums: IntArray): Boolean {
        val d = mutableMapOf<Int, PriorityQueue<Int>>()
        
        for (v in nums) {
            if (d.containsKey(v - 1)) {
                val q = d[v - 1]
                d.computeIfAbsent(v) { PriorityQueue() }.offer(q!!.poll() + 1)
                if (q.isEmpty()) d.remove(v - 1)
            } else d.computeIfAbsent(v) { PriorityQueue() }.offer(1)
        }
        
        for (v in d.values) {
            if (v.peek() < 3) return false
        }
        
        return true
    }
}

