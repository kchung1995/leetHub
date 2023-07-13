import java.util.*

class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val indegree = IntArray(numCourses)
        val adj: MutableList<MutableList<Int>> = ArrayList(numCourses)

        for (i in 0 until numCourses) {
            adj.add(ArrayList())
        }

        for (prerequisite in prerequisites) {
            adj[prerequisite[1]].add(prerequisite[0])
            indegree[prerequisite[0]]++
        }

        val queue: Queue<Int> = LinkedList()
        for (i in 0 until numCourses) {
            if (indegree[i] == 0) {
                queue.offer(i)
            }
        }

        var nodesVisited = 0
        while (!queue.isEmpty()) {
            val node = queue.poll()
            nodesVisited++

            for (neighbor in adj[node]) {
                indegree[neighbor]--
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor)
                }
            }
        }

        return nodesVisited == numCourses
    }
}

