class Solution {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        if (s1 == s2) return true
        
        var differentIndexes = mutableListOf<Int>()
        for (i in 0 until s1.length) {
            if (s1[i] != s2[i]) {
                differentIndexes.add(i)
                if (differentIndexes.size > 2) return false
            }
        }

        if (differentIndexes.size != 2) return false
        val idxFirst = differentIndexes[0]
        val idxSecond = differentIndexes[1]

        return if (s1[idxFirst] == s2[idxSecond] && s1[idxSecond] == s2[idxFirst]) true
        else false
    }
}

