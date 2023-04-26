class Solution {
    fun addDigits(num: Int): Int {
        var result: Int = num
        while(result >= 10) {
            result = getDigitsSum(result)
        }
        return result
    }

    private fun getDigitsSum(num: Int): Int {
        var target = num
        var result: Int = 0

        while(target >= 10) {
            result += target / 10
            target %= 10
        }
        result += target
        return result
    }
}

