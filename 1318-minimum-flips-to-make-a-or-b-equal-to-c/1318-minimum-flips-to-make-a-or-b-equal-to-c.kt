class Solution {
    fun minFlips(a: Int, b: Int, c: Int): Int = Integer.bitCount((a or b).xor(c)) + Integer.bitCount((a and b and ((a or b) xor c)))
}

