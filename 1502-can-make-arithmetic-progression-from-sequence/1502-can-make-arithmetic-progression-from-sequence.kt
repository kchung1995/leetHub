class Solution {
    fun canMakeArithmeticProgression(arr: IntArray): Boolean {
        arr.sort()
        val firstDifference = arr[1] - arr[0]
        for (i in 2 until arr.size) {
            val currentDifference = arr[i] - arr[i - 1]
            if (currentDifference != firstDifference) return false
        }
        return true
    }
}

