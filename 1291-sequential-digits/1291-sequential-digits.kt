class Solution {
    fun sequentialDigits(low: Int, high: Int): List<Int> {
        val numbers: String = "123456789"
        val n = 10
        val result = mutableListOf<Int>()

        val lowLength: Int = low.toString().length
        val highLength: Int = high.toString().length
        for (currentLength in lowLength .. highLength) {
            for (start in 0 until n - currentLength) {
                val currentNumber = numbers.substring(start, start + currentLength).toInt()
                if (low <= currentNumber && currentNumber <= high) result.add(currentNumber)
            }
        }

        return result
    }
}

