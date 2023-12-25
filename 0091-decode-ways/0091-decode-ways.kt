class Solution {
    val dictionary = HashMap<Int, Int>()
    
    fun numDecodings(s: String): Int {
        return recursive(0, s)
    }

    private fun recursive(index: Int, string: String): Int {
        when {
            dictionary.containsKey(index) -> return dictionary[index]!!
            index == string.length -> return 1
            string[index] == '0' -> return 0
            index == string.length - 1 -> return 1
        }

        var result: Int = recursive(index + 1, string)
        if (string.substring(index, index + 2).toInt() <= 26)
            result += recursive(index + 2, string)
        
        dictionary[index] = result
        return result
    }
}

