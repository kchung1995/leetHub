class Solution {
    fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
        if (source == target) return 0

        val adjacents: MutableMap<Int, List<Int>> = HashMap<Int, List<Int>>()
        for (r in 0 until routes.size) {
            for (stop in routes[r]) {
                val route: List<Int> = adjacents[stop] ?: emptyList()
                adjacents.put(stop, route + r)
            }
        }

        if (adjacents[source] == null || adjacents[target] == null) return -1

        val queue = mutableListOf<Int>()
        val visited = mutableSetOf<Int>()

        for (route in adjacents[source]!!) {
            queue.add(route)
            visited.add(route)
        }

        var busCount: Int = 1
        while (queue.isNotEmpty()) {
            val n = queue.size
            for (i in 0 until n) {
                val route = queue.removeFirst()

                for (stop in routes[route]) {
                    if (stop == target) return busCount

                    for (nextRoute in adjacents[stop]!!) {
                        if (visited.contains(nextRoute).not()) {
                            queue.add(nextRoute)
                            visited.add(nextRoute)
                        }
                    }
                }
            }

            busCount++
        }

        return -1
    }
}

