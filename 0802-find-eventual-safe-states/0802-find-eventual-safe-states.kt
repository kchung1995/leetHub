import java.util.*

class Solution {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val n = graph.size
        val indegree = IntArray(n)
        val adjacent: MutableList<MutableList<Int>> = ArrayList()

        for (i in 0 until n) {
            adjacent.add(ArrayList())
        }

        for (i in 0 until n) {
            for (node in graph[i]) {
                adjacent[node].add(i)
                indegree[i]++
            }
        }

        val q: Queue<Int> = LinkedList()
        for (i in 0 until n) {
            if (indegree[i] == 0) q.add(i)
        }

        val safe = BooleanArray(n)
        while (q.isNotEmpty()) {
            val node = q.poll()
            safe[node] = true

            for (neighbor in adjacent[node]) {
                indegree[neighbor]--
                if (indegree[neighbor] == 0) q.add(neighbor)
            }
        }

        val safeNodes: MutableList<Int> = ArrayList()
        for (i in 0 until n) {
            if (safe[i]) safeNodes.add(i)
        }

        return safeNodes
    }
}

