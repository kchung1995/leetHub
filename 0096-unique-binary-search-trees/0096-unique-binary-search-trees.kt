class Solution {
    fun numTrees(n: Int): Int {
        val count = IntArray(n + 1)
        count[0] = 1
        count[1] = 1

        for (i in 2 .. n) {
            for (j in 1 .. i) {
                count[i] += count[j - 1] * count[i - j]
            }
        }
        return count[n]
    }
}

