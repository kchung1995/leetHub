data class Monster(val initialDistance: Int, val speed: Int, val arrivalTime: Int)

class Solution {
    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
        val n: Int = dist.size
        val monsters = (0 until n).map { i ->
            Monster(
                initialDistance = dist[i],
                speed = speed[i],
                arrivalTime = (dist[i] / speed[i]) + if (dist[i] % speed[i] == 0) 0 else 1
            )
        }.sortedBy { it.arrivalTime }

        for (t in 0 until n) {
            if (monsters[t].arrivalTime <= t) return t
        }
        return n
    }
}

