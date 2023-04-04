class Solution {
    fun partitionString(s: String): Int {
        var result = 0
        val partition: HashSet<Char> = HashSet()
        for (i in s) {
            if (partition.contains(i)) {
                result++
                partition.clear()
            }
            partition.add(i)
        }

        return result + 1
    }
}
