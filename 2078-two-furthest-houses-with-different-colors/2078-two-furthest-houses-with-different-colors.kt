class Solution {
    fun maxDistance(colors: IntArray): Int {
        val n = colors.size
        var i: Int = 0
        var j: Int = n - 1

        while (colors[n - 1] == colors[i]) i++
        while (colors[0] == colors[j]) j--
        return maxOf(n - 1 - i, j);
    }
}

