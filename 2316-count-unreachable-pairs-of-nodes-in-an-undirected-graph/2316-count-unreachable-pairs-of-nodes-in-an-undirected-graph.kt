class Solution {
    private val MAX_N: Int = 100001
    private val parent = IntArray(MAX_N) { it }
    
    fun countPairs(n: Int, edges: Array<IntArray>): Long {
        for (i in edges) {
            makePair(i[0], i[1])
        }
        
        var result: Long = 0
        var remainingN = n
        val s = hashMapOf<Int, Int>()
        
        for (i in 0 until n) {
            val p = getParent(i)
            when (s.containsKey(p)) {
                true -> s[p] = s[p]!! + 1
                else -> s.put(p, 1)
            }
        }
        
        for ((key, value) in s) {
            remainingN -= value
            result += value.toLong() * remainingN.toLong()
        }
        
        return result
    }
    
    private fun getParent(x: Int): Int = when {
            x == parent[x] -> x
            else -> {
                parent[x] = getParent(parent[x])
                parent[x]
            }
    }
    
    private fun makePair(baseX: Int, baseY: Int) {
        val x = getParent(baseX)
        val y = getParent(baseY)

        when (x < y) {
            true -> parent[y] = x
            else -> parent[x] = y
        }
    }
}
