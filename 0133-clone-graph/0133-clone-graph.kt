/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null

        val marked = HashMap<Node, Node>()
        val q: Queue<Node> = LinkedList<Node>()

        marked[node] = Node(node.`val`)
        q.add(node)

        // bfs
        while(q.isNotEmpty()) {
            val current = q.poll()
            for (next in current.neighbors) {
                requireNotNull(next)
                if (!marked.containsKey(next)) {
                    marked[next] = Node(next.`val`)
                    q.add(next)
                }
                marked[current]?.neighbors?.add(marked[next])
            }
        }

        return marked[node]
    }
}
