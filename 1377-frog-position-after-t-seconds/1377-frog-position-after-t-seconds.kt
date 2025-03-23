class Solution {
    fun frogPosition(n: Int, edges: Array<IntArray>, t: Int, target: Int): Double {
        val graph = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            graph[e[0] - 1].add(e[1] - 1)
            graph[e[1] - 1].add(e[0] - 1)
        }

        val visited = BooleanArray(n).apply { this[0] = true }
        val prob = DoubleArray(n).apply { this[0] = 1.0 }
        val queue: Queue<Int> = LinkedList<Int>().apply { offer(0) }

        var remainingTime = t
        while (queue.isNotEmpty() && remainingTime-- > 0) {
            repeat(queue.size) {
                val u = queue.poll()

                val nextVerticesCount = graph[u].count { !visited[it] }
                
                for (v in graph[u]) {
                    if (!visited[v]) {
                        visited[v] = true
                        queue.offer(v)
                        prob[v] = prob[u] / nextVerticesCount
                    }
                }
                
                if (nextVerticesCount > 0) prob[u] = 0.0
            }
        }
        return prob[target - 1]
    }
}

