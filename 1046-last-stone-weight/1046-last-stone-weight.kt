class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val pq = PriorityQueue<Int>(Collections.reverseOrder())
        for (i in stones) pq.add(i)

        while(pq.size > 1) {
            val first = pq.poll()
            val second = pq.poll()
            val smashed = Math.abs(first - second)

            if (smashed != 0) pq.add(smashed)
        }

        if(pq.isEmpty()) return 0 else return pq.peek()
    }
}

