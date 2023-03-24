data class Node(val index: Int, val distance: Int) 

class Solution {
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val graph = Array<MutableList<Node>>(n) { mutableListOf<Node>() }
        val visited = BooleanArray(n)
        
        for (edge in connections) {
            graph[edge[0]].add(Node(edge[1], 1))
            graph[edge[1]].add(Node(edge[0], 0))
        }
        
        var result = 0
        
        fun dfs(node: Int) {
            visited[node] = true
            for (edge in graph[node]) {
                if (!visited[edge.index]) {
                    result += edge.distance
                    dfs(edge.index)
                }
            }
        }
        
        dfs(0)
        return result
    }
}

