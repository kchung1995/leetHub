class Solution {
    fun escapeGhosts(ghosts: Array<IntArray>, target: IntArray): Boolean {
        val source = IntArray(2) { 0 }

        for (ghost in ghosts) {
            if (taxi(ghost, target) <= taxi(source, target)) return false
        }
        return true
    }

    private fun taxi(p: IntArray, q: IntArray): Int {
        return (
            (p[0] - q[0]).toDouble().absoluteValue
            + (p[1] - q[1]).toDouble().absoluteValue
         ).toInt()
    }
}

