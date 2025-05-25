import java.lang.Long.compare

class Solution {
    fun minimizedMaximum(n: Int, quantities: IntArray): Int {
        val m = quantities.size
        val pq = PriorityQueue<IntArray> { a, b ->
            compare(b[0].toLong() * a[1], a[0].toLong() * b[1])
        }
        for (q in quantities) pq.offer(intArrayOf(q, 1))

        repeat(n - m) {
            val top = pq.poll()
            pq.offer(intArrayOf(top[0], top[1] + 1))
        }

        val top = pq.poll()
        return ceil(top[0].toDouble() / top[1]).toInt()
    }
}

