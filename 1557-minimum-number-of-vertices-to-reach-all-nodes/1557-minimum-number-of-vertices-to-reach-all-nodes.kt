class Solution {
    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val connections = IntArray(n) { 0 }
        val result = mutableListOf<Int>()

        for (edge in edges) {
            connections[edge[1]]++
        }
        for (i in 0 until n) {
            if (connections[i] == 0) result.add(i)
        }

        return result
    }
}

