class Solution {
    private val dictionary = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )
    
    private val subtractionDictionary = mapOf(
        "IV" to 4,
        "IX" to 9,
        "XL" to 40,
        "XC" to 90,
        "CD" to 400,
        "CM" to 900
    )

    fun romanToInt(s: String): Int {
        val n = s.length
        var i: Int = 0
        var result: Int = 0

        while (i < n) {
            if (i < n - 1) {
                val candidate = s.substring(i, i + 2)
                if (subtractionDictionary.contains(candidate)) {
                    result += requireNotNull(subtractionDictionary[candidate])
                    i += 2
                    continue
                }
            }
            val candidate = s[i]
            result += requireNotNull(dictionary[candidate])
            i++
        }
        return result
    }
}

