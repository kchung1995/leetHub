class Solution {
    fun maxNumberOfBalloons(text: String): Int {
        val charCount = mutableMapOf<Char, Int>()
        for (character in text) {
            charCount[character] = charCount.getOrDefault(character, 0) + 1
        }

        // b: 1
        // a: 1
        // l: 2
        // o: 2
        // n: 1
        return minOf(
            charCount.getOrDefault('b', 0),
            charCount.getOrDefault('a', 0),
            charCount.getOrDefault('l', 0) / 2,
            charCount.getOrDefault('o', 0) / 2,
            charCount.getOrDefault('n', 0)
        )
    }
}

