class Solution {
    fun mostPoints(questions: Array<IntArray>): Long {
        val n = questions.size
        val answerList = LongArray(n + 1) { 0 }

        for (i in n - 1 downTo 0) {
            val point = questions[i][0]
            val jump = questions[i][1]

            val index = minOf(i + jump + 1, n)
            val current = point + answerList[index]
            answerList[i] = maxOf(current, answerList[i + 1])
        }

        return answerList[0]
    }
}

