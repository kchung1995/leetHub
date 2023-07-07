class Solution {
    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
        var result: Int = 0
        val count = HashMap<Char, Int>()

        for (i in 0 until answerKey.length) {
            count.put(answerKey[i], count.getOrDefault(answerKey[i], 0) + 1)
            val minor = minOf(count.getOrDefault('T', 0), count.getOrDefault('F', 0))

            if (minor <= k) result++
            else count.put(answerKey[i - result], count.get(answerKey[i - result])!! - 1)
        }
        return result
    }
}

