class Solution {
    fun getWinner(arr: IntArray, k: Int): Int {
        val maxElement = arr.max()

        var current: Int = arr[0]
        var winningStreak: Int = 0

        for (i in 1 until arr.size) {
            val opponent = arr[i]
            if (current > opponent) winningStreak++
            else {
                current = opponent
                winningStreak = 1
            }

            if (winningStreak == k || current == maxElement) return current
        }

        return -1
    }
}

