class Solution {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val zeroLosses = mutableSetOf<Int>()
        val oneLosses = mutableSetOf<Int>()

        matches.forEach { match ->
            zeroLosses.add(match[0])
            zeroLosses.add(match[1])
        }

        matches.forEach { match ->
            if (oneLosses.contains(match[1])) {
                oneLosses.remove(match[1])
            }
            if (zeroLosses.contains(match[1])) {
                zeroLosses.remove(match[1])
                oneLosses.add(match[1])
            }
        }

        return listOf(
            zeroLosses.toList().sorted(),
            oneLosses.toList().sorted()
        )
    }
}

