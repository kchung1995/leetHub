class Solution {
    fun removeDuplicateLetters(s: String): String {
        var result: String = ""
        val count = IntArray(128)
        val used = BooleanArray(128)

        for (currentChar in s) {
            count[currentChar.toInt()]++
        }

        for (currentChar in s) {
            val current = currentChar.toInt()
            count[current]--
            if (used[current]) continue

            while (result != "" 
                && result.last() > currentChar
                && count[result.last().toInt()] > 0
            ) {
                used[result.last().toInt()] = false
                result = result.substring(0, result.length - 1)
            }

            used[current] = true
            result += currentChar
        }

        return result
    }
}

