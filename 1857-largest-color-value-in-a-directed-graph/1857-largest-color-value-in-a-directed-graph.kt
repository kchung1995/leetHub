data class NodesConnection(
    val graph: HashMap<Int, HashSet<Int>>,
    val indegrees: IntArray
)

class Solution {
    private val ALPHABET_COUNT = 26

    fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
        val colorLength = colors.length
        var result: Int = 0

        val graphs = buildGraph(colorLength, edges)
        val charFrequency = Array(colorLength) { IntArray(ALPHABET_COUNT) }
        val q: Queue<Int> = LinkedList<Int>()

        for ((i, indegree) in graphs.indegrees.withIndex()) {
            if (indegree != 0) continue
            q.add(i)
            charFrequency[i][colors[i] - 'a'] = 1
        }

        var seen: Int = 0
        while(q.isNotEmpty()) {
            val current = q.poll()
            seen++

            result = maxOf(result, charFrequency[current].max() ?: -1)
            graphs.graph[current]?.let{
                for (next in graphs.graph[current]!!) {
                    for (alphabet in 0 until ALPHABET_COUNT) {
                        val compareto = charFrequency[current][alphabet] + if(colors[next] - 'a' == alphabet) 1 else 0
                        charFrequency[next][alphabet] = maxOf(charFrequency[next][alphabet], compareto)
                    }
                    
                    if(--graphs.indegrees[next] == 0)
                    q.add(next)
                }
            }
        }

        return when (seen == colorLength) {
            true -> result
            else -> -1
        }
    }

    private fun buildGraph(length: Int, edges: Array<IntArray>): NodesConnection {
        val graph = HashMap<Int, HashSet<Int>>()
        val indegrees = IntArray(length) { 0 }

        for ((u, v) in edges) {
            graph.getOrPut(u){HashSet()}.add(v)
            indegrees[v]++
        }

        return NodesConnection(graph, indegrees)
    }
}

