class Solution {
    fun minimumDeleteSum(s1: String, s2: String): Int {
        if(s1.length < s2.length) return minimumDeleteSum(s2, s1)

        val m = s1.length
        val n = s2.length
        val currentRow = IntArray(n + 1)
        for (j in 1..n) {
            currentRow[j] = currentRow[j - 1] + s2[j - 1].toInt()
        }

        for (i in 1..m) {
            var diagonal = currentRow[0]
            currentRow[0] += s1[i - 1].toInt()
            
            for (j in 1..n) {
                var result = 0

                result = when {
                    s1[i - 1] == s2[j - 1] -> diagonal
                    else -> minOf(
                        s1[i - 1].toInt() + currentRow[j],
                        s2[j - 1].toInt() + currentRow[j - 1]
                    )
                }
                
                diagonal = currentRow[j]
                currentRow[j] = result
            }
        }
        
        return currentRow[n]
    }
}

