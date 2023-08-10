class Solution {
    private val MAX_EDGE_VAL = 1000

    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val dsu = DSU(MAX_EDGE_VAL + 1)
        for (edge in edges) {
            if (dsu.union(edge[0], edge[1]).not()) return edge
        }
        throw AssertionError()
    }
}

class DSU(size: Int) {
    private val parent: IntArray = IntArray(size) { it }
    private val rank: IntArray = IntArray(size)

    fun find(x: Int): Int {
        if (parent[x] != x) parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(x: Int, y: Int): Boolean {
        val xr = find(x)
        val yr = find(y)

        when {
            xr == yr -> return false
            rank[xr] < rank[yr] -> parent[xr] = yr
            rank[xr] > rank[yr] -> parent[yr] = xr
            else -> {
                parent[yr] = xr
                rank[xr]++
            }
        }
        return true
    }
}

