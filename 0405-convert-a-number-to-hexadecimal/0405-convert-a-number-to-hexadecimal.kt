class Solution {
    private val toHex = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f")
    
    fun toHex(num: Int): String {
        if (num == 0) return "0"
        var currentNum: Int = num
        
        var result: String = ""
        while(currentNum != 0) {
            val idx = currentNum and 15
            result = toHex[idx] + result
            currentNum = currentNum ushr 4
        }

        return result
    }
}

