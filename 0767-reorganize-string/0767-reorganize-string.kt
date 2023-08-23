data class CharCount(val alphabet: Char, val count: Int = 1) : Comparable<CharCount> {
    override fun compareTo(other: CharCount): Int =
        when {
            this.count > other.count -> -1
            this.count < other.count -> 1
            else -> 0
        }
}

class Solution {
    fun reorganizeString(s: String): String {
        val n = s.length
        var mostElement: Int = 0

        val map = HashMap<Char, Int>()
        for (i in s) {
            if (i in map) map[i] = map[i]!! + 1
            else map[i] = 1
        }

        val pq = PriorityQueue<CharCount>()
        map.forEach { (alphabet, count) ->
            pq.add(CharCount(alphabet, count))
        }

        if (n % 2 == 0) {
            if (pq.peek().count > n / 2) return ""
        }
        else {
            if (pq.peek().count > (n / 2) + 1) return ""
        }

        var result: String = ""
        while (pq.isNotEmpty()) {
            val first = pq.poll()
            if (pq.isEmpty()) {
                result += first.alphabet
                break
            }
            val second = pq.poll()
            
            if (result == "" || result.last() != first.alphabet) {
                result += if (first.count >= second.count) first.alphabet else second.alphabet
                result += if (first.count >= second.count) second.alphabet else first.alphabet
            }
            else {
                result += second.alphabet
                result += first.alphabet
            }

            val nextFirst = first.copy(count = first.count - 1)
            val nextSecond = second.copy(count = second.count - 1)

            if (nextFirst.count > 0) pq.add(nextFirst)
            if (nextSecond.count > 0) pq.add(nextSecond)
        }

        return result
    }
}

