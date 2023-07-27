class Solution {
    fun maxRunTime(n: Int, batteries: IntArray): Long {
        var totalPower: Long = 0
        batteries.forEach {
            totalPower += it.toLong()
        }
        var left: Long = 1
        var right: Long = totalPower / n

        while (left < right) {
            val mid = right - ((right - left) / 2)

            var extra: Long = 0
            for (i in batteries) extra += minOf(i.toLong(), mid)

            val compare: Long = n * mid
            if (extra >= compare) left = mid
            else right = mid - 1
        }

        return left
    }
}

