class Solution {
    fun formulae(n: Long): Long {
        return ((n + 1) * n) / 2
    }
    
    fun numSub(s: String): Int {
        var answer: Long = 0
        val binaryList = s.split('0')
        
        for (i in binaryList) {
            if (i == "") continue
            answer = (answer + formulae(i.length.toLong())) % (1000000007)
        }
        
        return answer.toInt()
    }
}