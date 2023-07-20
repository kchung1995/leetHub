class Solution {
    var maxDepth: Int = -1
    val registeredSequences = hashSetOf<String>()

    fun numTilePossibilities(tiles: String): Int {
        maxDepth = tiles.length
        sequenceGenerator("", tiles, hashSetOf<Int>())

        return registeredSequences.size
    }

    private fun sequenceGenerator(basis: String, tiles: String, usedIndex: HashSet<Int>) {
        for (i in 0 until maxDepth) {
            if (usedIndex.contains(i)) continue
            val next = basis + tiles[i]

            if (registeredSequences.contains(next)) continue
            registeredSequences.add(next)

            if (next.length == maxDepth) continue
            usedIndex.add(i)
            sequenceGenerator(next, tiles, usedIndex)
            usedIndex.remove(i)
        }
    }
}
