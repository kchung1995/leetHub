class Solution {
    fun isReachableAtTime(sx: Int, sy: Int, fx: Int, fy: Int, t: Int): Boolean {
        val dx = absolute(sx - fx)
        val dy = absolute(sy - fy)

        val distance = maxOf(dx, dy)
        
        if (dx == 0 && dy == 0 && t == 1) return false
        return t >= maxOf(dx, dy)
    }

    private fun absolute(input: Int) = if (input < 0) -input else input
}

