class Solution {
    fun reverseString(s: CharArray): Unit {
        var startpoint = 0
        var endpoint = s.size - 1
        while(startpoint < endpoint) {
            val front = s[startpoint]
            val end = s[endpoint]
            s[startpoint] = end.also { s[endpoint] = front}
            startpoint++
            endpoint--
        }
        return
    }
}
