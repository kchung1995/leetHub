class Solution {
    fun maxLengthBetweenEqualCharacters(s: String): Int {
        var result: Int = -1
        val firstAppear: HashMap<Char, Int> = HashMap<Char, Int>()

        for (i in s.indices) {
            if (firstAppear.containsKey(s[i])) result = maxOf(result, i - firstAppear[s[i]]!! - 1)
            else firstAppear[s[i]] = i
        }

        return result
    }
}

