class Solution {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        var result: Int = 0

        for (i in 0 until tickets.size) {
            result += if (i <= k) {
                minOf(tickets[i], tickets[k])
            }
            else minOf(tickets[i], tickets[k] - 1)
        }

        return result
    }
}

