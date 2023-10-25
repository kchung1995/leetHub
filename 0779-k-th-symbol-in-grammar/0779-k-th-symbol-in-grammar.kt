class Solution {
    fun kthGrammar(n: Int, k: Int): Int {
        return dfs(n, k, 0)
    }

    private fun dfs(n: Int, k: Int, rootValue: Int): Int {
        if (n == 1) return rootValue

        val nodesCount = Math.pow(2.toDouble(), (n - 1).toDouble()).toInt()
        
        return if (k > (nodesCount / 2)) {
            val nextRootValue = if (rootValue == 0) 1 else 0
            dfs(n - 1, k - (nodesCount / 2), nextRootValue);
        }
        else {
            val nextRootValue = if (rootValue == 0) 0 else 1
            dfs(n - 1, k, nextRootValue);
        }
    }
}
