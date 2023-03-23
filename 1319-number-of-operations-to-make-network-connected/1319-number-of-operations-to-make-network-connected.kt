class Solution {
    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        if (!hasEnoughCables(n, connections)) return -1
        return getUnionGroups(n, connections) - 1
    }
    
    private fun find(x: Int, parent: IntArray): Int {
        return when (parent[x]) {
            x -> x
            else -> {
                parent[x] = find(parent[x], parent)
                parent[x]
            }
        }
    }
    
    private fun makeUnion(originX: Int, originY: Int, parent: IntArray) {
        val x = find(originX, parent)
        val y = find(originY, parent)
        
        when (x < y) {
            true -> parent[y] = x
            else -> parent[x] = y
        }
    }
    
    private fun getUnionGroups(n: Int, connections: Array<IntArray>): Int {
        val parent = IntArray(n) { it }
        
        for (con in connections) {
            makeUnion(con[0], con[1], parent)
        }
        for (con in connections) {
            makeUnion(con[0], con[1], parent)
        }
        
        val s = HashSet<Int>()
        for (i in parent) {
            s.add(i)
        }
        
        return s.size
    }
    
    private fun hasEnoughCables(n: Int, connections: Array<IntArray>): Boolean = connections.size >= (n - 1)
}

