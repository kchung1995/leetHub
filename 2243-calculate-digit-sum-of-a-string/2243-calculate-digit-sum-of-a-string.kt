class Solution {
    fun digitSum(s: String, k: Int): String {
        var currentString: String = s
        while (currentString.length > k) {
            val groups = currentString.toConsecutiveGroups(k)
            currentString = groups
                .map { it.sumOfItsDigits().toString() }
                .joinToString(separator = "")
        }

        return currentString
    }

    private fun String.toConsecutiveGroups(k: Int): List<String> {
        val n = this.length
        val result = (0 until n step k).map {
            this.substring(it, min(it + k, n))
        }
        return result
    }

    private fun String.sumOfItsDigits(): Int {
        return this.map { ch ->
            ch.digitToInt()
        }
        .sum()
    }
}

