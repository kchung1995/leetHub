class Solution {
    fun buildArray(target: IntArray, n: Int): List<String> {
        val result = mutableListOf<String>()

        var i: Int = 0
        for (number in target) {
            while (i < number - 1) {
                result.add("Push")
                result.add("Pop")
                i++
            }
            
            result.add("Push")
            i++
        }

        return result
    }
}

