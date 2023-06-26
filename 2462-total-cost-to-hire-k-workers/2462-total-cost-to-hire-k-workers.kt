class Solution {
    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        val pq = PriorityQueue<IntArray> { a, b ->
            if (a[0] == b[0]) a[1] - b[1]
            else a[0] - b[0]
        }

        for (i in 0 until candidates) {
            pq.add(intArrayOf(costs[i], 0))
        }
        for (i in maxOf(candidates, costs.size - candidates) until costs.size) {
            pq.add(intArrayOf(costs[i], 1))
        }

        var answer: Long = 0
        var nextHead: Int = candidates
        var nextTail: Int = costs.size - 1 - candidates

        for (i in 0 until k) {
            val curWorker = pq.poll()
            val curCost = curWorker[0]
            val curSectionId = curWorker[1]
            answer += curCost.toLong()

            if (nextHead <= nextTail) {
                if (curSectionId == 0) {
                    pq.offer(intArrayOf(costs[nextHead], 0))
                    nextHead++
                } else {
                    pq.offer(intArrayOf(costs[nextTail], 1))
                    nextTail--
                }
            }
        }

        return answer
    }
}
