data class PileHead(val pile: Int, val head: Int, val headValue: Int)

class Solution {
    private val lambda = { a: PileHead, b: PileHead -> when {
        a.headValue < b.headValue -> -1
        a.headValue > b.headValue -> 1
        else -> 0
    }}
    
    fun maxValueOfCoins(piles: List<List<Int>>, k: Int): Int {
        var result: Int = 0
        var coins: Int = 0
        val pq = PriorityQueue(Comparator<PileHead> { a, b ->
            lambda(a, b)
        })

        var pileIndex: Int = 0
        for (i in piles) {
            val pileSize = i.size
            if (pileSize < k) {
                val sum = i.sum()
                result += sum
                coins += pileSize
                pq.add(PileHead(pileIndex, pileSize - 1, i.last()))
            } else {
                var sum: Int = 0
                for (j in 0 until k) sum += i[j]
                result += sum
                coins += k
                pq.add(PileHead(pileIndex, k - 1, i[k - 1]))
            }
            pileIndex++
        }

        while (coins > k) {
            val current = pq.poll()
            coins--

            result -= current.headValue
            if (current.head > 0) {
                val next = current.copy(
                    head = current.head - 1,
                    headValue = piles[current.pile][current.head - 1]
                )
                pq.add(next)
            }
        }

        return result
    }
}
