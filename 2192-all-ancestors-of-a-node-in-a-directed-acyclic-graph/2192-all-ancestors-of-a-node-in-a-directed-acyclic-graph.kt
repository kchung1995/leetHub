class Solution {
    fun getAncestors(n: Int, edges: Array<IntArray>): List<List<Int>> {
        val graph = List(n) { mutableListOf<Int>() }
        val inDegree = IntArray(n)
        for (edge in edges) {
            val (u, v) = edge
            graph[u].add(v)
            inDegree[v]++
        }
  
        val ancestors = List(n) { mutableSetOf<Int>() }
        val queue: ArrayDeque<Int> = ArrayDeque()

        for (i in 0 until n) {
            if (inDegree[i] == 0) {
                queue.add(i)
            }
        }
        
        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            for (child in graph[curr]) {
                ancestors[child].add(curr)
                ancestors[child].addAll(ancestors[curr])
                
                inDegree[child]--
                if (inDegree[child] == 0) {
                    queue.add(child)
                }
            }
        }
        
        return ancestors.map { it.toList().sorted() }
    }
}

