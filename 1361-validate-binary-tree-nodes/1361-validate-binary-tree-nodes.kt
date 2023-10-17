class Solution {
    fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
        val uf = UnionFind(n)
        for (node in 0 until n) {
            val children = intArrayOf(leftChild[node], rightChild[node])
            for (child in children) {
                if (child == -1) {
                    continue
                }

                if (!uf.union(node, child)) {
                    return false
                }
            }
        }

        return uf.components == 1
    }
}

class UnionFind(private val n: Int) {
    private val parents: IntArray = IntArray(n) { it } 
    var components: Int = n
        private set

    fun union(parent: Int, child: Int): Boolean {
        val parentParent = find(parent)
        val childParent = find(child)

        if (childParent != child || parentParent == childParent) {
            return false
        }

        components--
        parents[childParent] = parentParent
        return true
    }

    private fun find(node: Int): Int {
        if (parents[node] != node) {
            parents[node] = find(parents[node])
        }

        return parents[node]
    }
}

