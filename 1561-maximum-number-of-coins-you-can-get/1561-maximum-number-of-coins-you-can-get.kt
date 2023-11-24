class Solution {
    fun maxCoins(piles: IntArray): Int {
        piles.sort()
        val queue: ArrayDeque<Int> = ArrayDeque()
        for (i in piles) queue.addLast(i)

        var result: Int = 0
        while(queue.isNotEmpty()) {
            queue.removeLast()
            result += queue.removeLast()
            queue.removeFirst()
        }

        return result
    }
}

