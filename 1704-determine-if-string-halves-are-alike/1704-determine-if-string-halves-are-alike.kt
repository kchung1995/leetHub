class Solution {
    private val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')

    fun halvesAreAlike(s: String): Boolean {

        val n = s.length
        val first = s.substring(0, n / 2)
        val second = s.substring(n/ 2, n)

        val firstCount: Int = first
            .map { vowels. contains(it) }
            .count { it == true}

        val secondCount: Int = second
            .map { vowels. contains(it) }
            .count { it == true}

        return firstCount == secondCount
    }
}

