class Solution {
    fun removePalindromeSub(s: String): Int {
        return when {
            s.isEmpty() -> 0
            s.reversed().equals(s) -> 1
            else -> 2
        }
    }
}

