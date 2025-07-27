class Graph(n: Int, edges: Array<IntArray>) {
    private val adjacentMatrix: Array<IntArray>
    private val INF = 1e9.toInt()

    init {
        adjacentMatrix = Array(n) { IntArray(n) { INF } }

        for ((u, v, w) in edges) {
            adjacentMatrix[u][v] = w
        }
        for (i in 0 until n) {
            adjacentMatrix[i][i] = 0
        }

        for (k in 0 until n) {
            for (i in 0 until n) {
                for (j in 0 until n) {
                    adjacentMatrix[i][j] = minOf(adjacentMatrix[i][j],
                                            adjacentMatrix[i][k] + adjacentMatrix[k][j])
                }
            }
        }
    }

    fun addEdge(edge: IntArray) {
        val (u, v, w) = edge
        val size = adjacentMatrix.size     

        for (i in 0 until size) {
            for (j in 0 until size) {
                adjacentMatrix[i][j] = minOf(
                    adjacentMatrix[i][j],
                    adjacentMatrix[i][u] + adjacentMatrix[v][j] + w
                )
            }
        }   
    }

    fun shortestPath(node1: Int, node2: Int): Int {
        val distance = adjacentMatrix[node1][node2]
        return if (distance >= INF) -1 else distance
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * var obj = Graph(n, edges)
 * obj.addEdge(edge)
 * var param_2 = obj.shortestPath(node1,node2)
 */
