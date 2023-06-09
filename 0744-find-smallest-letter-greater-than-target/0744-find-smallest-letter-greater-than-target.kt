class Solution {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        letters.sort()
        var left: Int = 0
        var right: Int = letters.size - 1

        while (left <= right) {
            val mid = left + ((right - left) / 2)
            if (letters[mid] <= target) left = mid + 1
            else right = mid - 1
        }

        return if (left == letters.size) letters[0] else letters[left]
    }
}

