class Solution {
    fun findSpecialInteger(arr: IntArray): Int {
        val n = arr.size / 4
        
        var prev: Int = -1
        var count: Int = 0
        for (i in arr) {
            if (i != prev) {
                prev = i
                count = 1
            }
            else count++
            if (count > n) return i
        }
        
        return -1
    }
}
