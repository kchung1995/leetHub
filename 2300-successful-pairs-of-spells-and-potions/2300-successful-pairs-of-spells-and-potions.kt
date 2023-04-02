class Solution {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        val n = spells.size
        val m = potions.size
        val result = IntArray(n)
        potions.sort()

        for (i in 0 until n) {
            val spell = spells[i]
            val minimumBoundary: Long = getMinimumBoundaryValue(success, spell)

            if (potions.last() < minimumBoundary) {
                result[i] = 0
                continue
            }

            // binary search
            var left = 0
            var right = m - 1
            var mid = -1
            var finalMid = -1
            while (left <= right) {
                mid = left + ((right - left) / 2)
                when {
                    potions[mid].toLong() < minimumBoundary -> left = mid + 1
                    potions[mid].toLong() >= minimumBoundary -> {
                        right = mid - 1
                        finalMid = mid
                    }
                }
            }
            require(mid != -1)
            result[i] = m - finalMid
        }
        return result
    }

    private fun getMinimumBoundaryValue(success: Long, spell: Int): Long {
        val longSpell = spell.toLong()
        var result = (success / longSpell)
        if (success % longSpell != 0L) result++
        return result
    }
}
