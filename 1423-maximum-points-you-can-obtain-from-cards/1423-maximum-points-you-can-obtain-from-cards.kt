class Solution {
    var cardPointsSize: Int = 0

    fun maxScore(cardPoints: IntArray, k: Int): Int {
        cardPointsSize = cardPoints.size
        if (k == cardPointsSize) return cardPoints.sum()

        return slidingWindow(cardPoints, k)
    }

    private fun slidingWindow(cardPoints: IntArray, k: Int): Int {
        var result: Int = 0
        var currentSum: Int = 0

        for (i in 0 until k) {
            currentSum += cardPoints[i]
            println(cardPoints[i])
        }
        result = maxOf(result, currentSum)

        var tail: Int = k - 1
        var head: Int = cardPointsSize - 1

        while (tail >= 0) {
            currentSum -= cardPoints[tail]
            currentSum += cardPoints[head]
            result = maxOf(result, currentSum)
            tail--
            head--
        }

        return result
    }
}
