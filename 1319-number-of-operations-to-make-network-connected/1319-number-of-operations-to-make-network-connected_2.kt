class Solution {
    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        if (connections.size < n - 1) return -1

        val adjacent = HashMap<Int, MutableList<Int>>()
        for (connection in connections) {
            adjacent.computeIfAbsent(connection[0]) { ArrayList() }.add(connection[1])
            adjacent.computeIfAbsent(connection[1]) { ArrayList() }.add(connection[0])
        }

        var numberOfConnectedComponents = 0
        val visit = BooleanArray(n)
        for (i in 0 until n) {
            if (visit[i]) continue
            numberOfConnectedComponents++
            dfs(i, adjacent, visit)
        }

        return numberOfConnectedComponents - 1
    }

    private fun dfs(node: Int, adjacent: Map<Int, List<Int>>, visit: BooleanArray) {
        visit[node] = true
        if (adjacent.containsKey(node).not()) return

        for (neighbour in adjacent[node]!!) {
            if (visit[neighbour]) continue
            visit[neighbour] = true
            dfs(neighbour, adjacent, visit)
        }
    }
}

