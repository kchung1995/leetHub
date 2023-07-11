/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
        val graph = HashMap<Int, MutableList<Int>>()
        dfs(root, null, graph)

        val answer = ArrayList<Int>()
        val visited = HashSet<Int>()
        val queue = LinkedList<IntArray>()

        queue.add(intArrayOf(target?.`val` ?: 0, 0))
        visited.add(target?.`val` ?: 0)

        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            val node = cur[0]
            val distance = cur[1]

            if (distance == k) {
                answer.add(node)
                continue
            }

            for (neighbor in graph.getOrDefault(node, ArrayList())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor)
                    queue.add(intArrayOf(neighbor, distance + 1))
                }
            }
        }

        return answer
    }

    private fun dfs(cur: TreeNode?, parent: TreeNode?, graph: MutableMap<Int, MutableList<Int>>) {
        if (cur != null && parent != null) {
            val curVal = cur.`val`
            val parentVal = parent.`val`
            graph.putIfAbsent(curVal, ArrayList())
            graph.putIfAbsent(parentVal, ArrayList())
            graph[curVal]?.add(parentVal)
            graph[parentVal]?.add(curVal)
        }

        if (cur != null && cur.left != null) dfs(cur.left, cur, graph)
        if (cur != null && cur.right != null) dfs(cur.right, cur, graph)

    }
}

