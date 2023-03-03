class Solution {
    fun strStr(haystack: String, needle: String): Int {
        for (i in 0 until haystack.length - needle.length + 1) {
            if (haystack.substring(i, i + needle.length) == needle)
                return i
        }
        return -1
    }
}