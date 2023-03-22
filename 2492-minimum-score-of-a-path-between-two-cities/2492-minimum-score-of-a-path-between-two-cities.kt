data class Node(val destination: Int, val distance: Int)

class Solution {
    fun minScore(n: Int, roads: Array<IntArray>): Int {
        val nodes = List<MutableList<Node>>(n + 1) { mutableListOf<Node>() }
        val q: Queue<Int> = LinkedList<Int>()
        val isVisited = BooleanArray(n + 1) { false }
        var result = Integer.MAX_VALUE
        
        for (i in roads.indices) {
            nodes[roads[i][0]].add(Node(roads[i][1], roads[i][2]))
            nodes[roads[i][1]].add(Node(roads[i][0], roads[i][2]))
        }
        
        // bfs
        isVisited[1] = true
        q.add(1)
        while (q.isNotEmpty()) {
            val current = q.poll()
            
            for (next in nodes[current]) {
                result = minOf(result, next.distance)
                if (isVisited[next.destination]) continue
                q.add(next.destination)
                isVisited[next.destination] = true
            }
        }
        
        return result
    }
}
