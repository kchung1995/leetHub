class Solution {
    fun numSimilarGroups(strs: Array<String>): Int {
        val n = strs.size
        val unionFind = UnionFind(n)

        for (i in 0 until n) {
            for (j in i + 1 until n) {
                if (isSimilar(strs[i], strs[j]))
                    unionFind.union(i, j)
            }
        }

        return unionFind.count
    }

    private fun isSimilar(a: String, b: String): Boolean {
        if (a.length != b.length) return false

        var diffCount: Int = 0
        for (i in a.indices) {
            if (a[i] != b[i]) {
                diffCount++
                if (diffCount > 2) return false
            }
        }

        return true
    }

    private class UnionFind(size: Int) {
        val parent = IntArray(size) { it }
        var count = size

        fun find(x: Int): Int {
            if (parent[x] != x) {
                parent[x] = find(parent[x])
            }
            return parent[x]
        }

        fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)
            if (rootX != rootY) {
                parent[rootX] = rootY
                count--
            }
        }
    }
}

