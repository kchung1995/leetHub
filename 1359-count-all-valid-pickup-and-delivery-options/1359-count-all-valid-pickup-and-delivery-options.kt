class Solution {
    fun countOrders(n: Int): Int {
        val kMod = 1000000000 + 7
        var result: Long = 1
        
        for (i in 1..n) {
            result = (result * i * (i * 2 - 1)) % kMod
        }
        return result.toInt()
    }
}

