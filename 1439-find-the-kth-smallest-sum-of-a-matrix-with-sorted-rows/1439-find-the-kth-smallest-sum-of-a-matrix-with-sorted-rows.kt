class Solution {
    fun kthSmallest(mat: Array<IntArray>, k: Int): Int {
        val column = minOf(mat[0].size, k)

        var pq = PriorityQueue<Int>(Collections.reverseOrder())
        pq.add(0)
        for (row in mat) {
            val nextPq = PriorityQueue<Int>(Collections.reverseOrder())

            for (i in pq) {
                for (element in row) {
                    nextPq.add(i + element)
                    if (nextPq.size > k) nextPq.poll()
                }
            }

            pq = nextPq
        }

        return pq.poll()
    }
}

