class Solution {
    private val parent = IntArray(200) { it }

    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val n = isConnected.size

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (isConnected[i][j] == 1) makeUnion(i, j)
            }
        }
        
        val result = HashSet<Int>()
        for (i in 0 until n) {
            result.add(getParent(i))
        }
        return result.size
    }

    private fun getParent(x: Int): Int = if (parent[x] == x) x else getParent(parent[x])

    private fun makeUnion(x: Int, y: Int) {
        val nx = getParent(x)
        val ny = getParent(y)
        when (nx <= ny) {
            true -> parent[ny] = parent[nx]
            else -> parent[nx] = parent[ny]
        }
    }
}

