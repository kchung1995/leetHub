class Solution {
    private var result: Long = 0
    
    private fun dfs(nodes: Array<MutableList<Int>>, u: Int, prev: Int, seats: Int): Int {
        var passenger = 1
        for (i in nodes[u]) {
            if (i == prev) continue
            passenger += dfs(nodes, i, u, seats)
        }
        
        if (u > 0)
            result += (passenger + seats - 1) / seats
        return passenger
    }
    
    fun minimumFuelCost(roads: Array<IntArray>, seats: Int): Long {
        val nodes = Array(roads.size + 1) { mutableListOf<Int>() }
        
        // set up bidirectional nodes
        for (i in roads) {
            val x = i[0]
            val y = i[1]
            nodes[x].add(y)
            nodes[y].add(x)
        }

        dfs(nodes, 0, -1, seats)
        
        return result
    }
}