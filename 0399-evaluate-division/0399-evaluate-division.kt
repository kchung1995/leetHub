class Solution {
    private val graph = HashMap<String, HashMap<String, Double>>()

    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {

        for (i in equations.indices) {
            val equation = equations[i]
            val a = equation[0]
            val b = equation[1]
            val value = values[i]

            graph.getOrPut(a) { HashMap() }[b] = value
            graph.getOrPut(b) { HashMap() }[a] = 1 / value
        }

        val results = DoubleArray(queries.size)
        for (i in queries.indices) {
            val query = queries[i]
            val a = query[0]
            val b = query[1]

            results[i] = dfs(a, b, HashSet())
        }

        return results
    }

    private fun dfs(a: String, b: String, visited: HashSet<String>): Double {
        if (!graph.containsKey(a) || !graph.containsKey(b)) return -1.0
        if (a == b) return 1.0

        visited.add(a)
        for ((neighbor, value) in graph[a]!!) {
            if (visited.contains(neighbor)) continue
            val result = dfs(neighbor, b, visited)
            if (result != -1.0) return value * result
        }

        return -1.0
    }
}

