class Solution {
    fun maximumDetonation(bombs: Array<IntArray>): Int {
        val graph = mutableMapOf<Int, MutableList<Int>>()
        val n = bombs.size

        for (i in 0 until n) {
            for (j in 0 until n) {
                val xi = bombs[i][0]
                val yi = bombs[i][1]
                val ri = bombs[i][2]
                val xj = bombs[j][0]
                val yj = bombs[j][1]

                if (isPathable(i, j, bombs)) {
                    graph.computeIfAbsent(i) { mutableListOf() }.add(j)
                }
            }
        }

        var answer = 0
        for (i in 0 until n) {
            answer = answer.coerceAtLeast(bfs(i, graph))
        }

        return answer
    }

    private fun isPathable(i: Int, j: Int, bombs: Array<IntArray>): Boolean {
        val xi = bombs[i][0]
        val yi = bombs[i][1]
        val ri = bombs[i][2]
        val xj = bombs[j][0]
        val yj = bombs[j][1]
        return ri.toLong() * ri >= (xi - xj).toLong() * (xi - xj) + (yi - yj).toLong() * (yi - yj)
    }

    private fun bfs(i: Int, graph: Map<Int, List<Int>>): Int {
        val queue: Queue<Int> = LinkedList<Int>()
        val visited: MutableSet<Int> = HashSet()
        queue.add(i)
        visited.add(i)

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            for (bomb in graph.getOrDefault(current, emptyList())) {
                if (!visited.contains(bomb)) {
                    visited.add(bomb)
                    queue.add(bomb)
                }
            }
        }
        return visited.size
    }
}

