class Solution {
    fun fairCandySwap(aliceSizes: IntArray, bobSizes: IntArray): IntArray {
        val result = IntArray(2)
        var aliceTotal = 0
        var bobTotal = 0
        val bobStuffs = mutableSetOf<Int>()
        
        for (i in aliceSizes) {
            aliceTotal += i
        }
        for (i in bobSizes) {
            bobStuffs.add(i)
            bobTotal += i
        }
        
        for (i in aliceSizes) {
            val b = (aliceTotal - bobTotal - 2*i) / -2
            if (bobStuffs.contains(b)) {
                result[0] = i
                result[1] = b
                return result
            }
        }
        
        return result   
    }
}