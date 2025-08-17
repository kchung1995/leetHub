class Solution {
    fun countCompleteComponents(n: Int, edges: Array<IntArray>): Int {
        val graph = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            val a = e[0]
            val b = e[1]
            graph[a].add(b)
            graph[b].add(a)
        }

        val visited = BooleanArray(n)
        var completeCount = 0

        for (v in 0 until n) {
            if (visited[v]) continue

            val info = IntArray(2)
            dfs(v, info, graph, visited)
            if (info[0] * (info[0] - 1) == info[1]) completeCount++
        }

        return completeCount
    }
    
    private fun dfs(curr: Int, info: IntArray, graph: Array<out List<Int>>, visited: BooleanArray) {
        visited[curr] = true
        info[0]++
        info[1] += graph[curr].size
        for (next in graph[curr]) {
            if (visited[next].not()) dfs(next, info, graph, visited)
        }
    }
}

