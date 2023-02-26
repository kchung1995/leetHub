class Solution {
    val MAX_N = 501
    
    fun minDistance(word1: String, word2: String): Int {
        // val editDistance: List<List<Int>> = ArrayList<ArrayList<Int>>(MAX_N)
        val editDistance = Array(MAX_N) { IntArray(MAX_N) }
        editDistance[0][0] = 0
        
        for (i in 1..word1.length) {
            editDistance[i][0] = i
        }
        for (i in 1..word2.length) {
            editDistance[0][i] = i
        }
        
        for (i in 1..word1.length) {
            for (j in 1..word2.length) {
                if (word1[i - 1] == word2[j - 1]) {
                    editDistance[i][j] = editDistance[i - 1][j - 1]
                }
                else {
                    editDistance[i][j] = minOf(
                        editDistance[i - 1][j],
                        editDistance[i][j - 1],
                        editDistance[i - 1][j - 1]
                    ) + 1
                }
            }
        }
        
        return editDistance[word1.length][word2.length]
    }
}