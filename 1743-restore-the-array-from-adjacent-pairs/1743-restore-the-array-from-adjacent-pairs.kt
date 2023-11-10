class Solution {
    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        val graph = mutableMapOf<Int, MutableList<Int>>()

        for (edge in adjacentPairs) {
            val x = edge[0]
            val y = edge[1]

            graph.computeIfAbsent(x) { mutableListOf() }
            graph.computeIfAbsent(y) { mutableListOf() }

            graph[x]!!.add(y)
            graph[y]!!.add(x)
        }

        var root: Int = 0
        for (num in graph.keys) {
            if (graph[num]!!.size == 1) {
                root = num
                break
            }
        }

        var current: Int = root
        val result = IntArray(graph.size)
        result[0] = root
        var i: Int = 1
        var prev = Integer.MAX_VALUE

        while (i < graph.size) {
            for (neighbor in graph[current]!!) {
                if (neighbor != prev) {
                    result[i] = neighbor
                    i++
                    prev = current
                    current = neighbor
                    break
                }
            }
        }

        return result
    }
}

