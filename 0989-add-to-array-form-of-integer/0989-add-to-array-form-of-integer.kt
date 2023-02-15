class Solution {
    fun addToArrayForm(num: IntArray, nk: Int): List<Int> {
        val result = mutableListOf<Int>()
        var k = nk
        
        for (i in num.size - 1 downTo 0) {
             result.add(0, (num[i] + k) % 10)
             k = (num[i] + k) / 10
        }
        
        while (k > 0) {
            result.add(0, k % 10)
            k /= 10
        }
        
        return result
    }
}