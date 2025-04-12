class Solution {
    fun countAndSay(n: Int): String {
        var result: String = "1"
        val regex = Regex("(.)\\1*")

        repeat(n - 1) {
            result = regex.findAll(result)
                .joinToString("") { matchResult ->
                    val group = matchResult.value
                    "${group.length}${group[0]}"
                }
        }
        return result
    }
}

