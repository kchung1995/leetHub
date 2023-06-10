class Solution {
    fun maxValue(n: Int, index: Int, maxSum: Int): Int {
        var left: Int = 1
        var right: Int = maxSum
        
        while (left < right) {
            val mid = (left + right + 1) / 2
            if (getSum(index, mid, n) <= maxSum) left = mid
            else right = mid - 1
        }
        return left
    }

    private fun getSum(index: Int, value: Int, n: Int): Long {
        var result: Long = 0

        if (value > index) result += (value * 2 - index).toLong() * (index + 1) / 2
        else result += (value + 1).toLong() * value / 2 + index - value + 1

        if (value >= n - index) result += (value * 2 - n + 1 + index).toLong() * (n - index) / 2
        else result += (value + 1).toLong() * value / 2 + n - index - value

        return result - value.toLong()
    }
}

