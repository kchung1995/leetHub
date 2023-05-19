data class Node(val node: Int, val color: Int)

class Solution {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val n = graph.size
        val color = IntArray(n) { -1 }

        for (i in 0 until n) {
            if (color[i] != -1) continue

            val q: Queue<Node> = LinkedList<Node>()
            q.add(Node(i, 0))
            color[i] = 0

            while(q.isNotEmpty()) {
                val nextNode = q.peek().node
                val nextColor = if(q.poll().color == 0) 1 else 0

                for (j in graph[nextNode]) {
                    if (color[j] != -1) {
                        if (color[j] != nextColor) return false
                        continue
                    }
                    color[j] = nextColor
                    q.add(Node(j, nextColor))
                }
            }
        }

        return true
    }
}

