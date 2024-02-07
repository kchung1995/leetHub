class Solution {
    fun frequencySort(s: String): String {
        val characterFrequencyCount = HashMap<Char, Int>()
        for (character in s) {
            if (characterFrequencyCount.containsKey(character)) characterFrequencyCount[character] = characterFrequencyCount[character]!! + 1
            else characterFrequencyCount[character] = 1
        }

        val counted = characterFrequencyCount
            .map { Pair(it.key, it.value) }
            .sortedByDescending { it.second }

        val result = StringBuilder()
        counted.forEach {
            for (i in 0 until it.second) {
                result.append(it.first)
            }
        }

        return result.toString()
    }
}

