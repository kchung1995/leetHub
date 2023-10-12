/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * class MountainArray {
 *     fun get(index: Int): Int {}
 *     fun length(): Int {}
 * }
 */

class Solution {
    fun findInMountainArray(target: Int, mountainArr: MountainArray): Int {
        val n = mountainArr.length()
        
        var low: Int = 1
        var high: Int = n - 2

        while (low != high) {
            val currentIndex = (low + high) shr 1
            val current = mountainArr.get(currentIndex)
            val next = mountainArr.get(currentIndex + 1)

            if (current < next) {
                if (current == target) return currentIndex
                if (next == target) return currentIndex + 1
                low = currentIndex + 1
            }
            else high = currentIndex
        }

        val peakIndex = low

        low = 0
        high = peakIndex

        while (low <= high) {
            val currentIndex = (low + high) shr 1
            val current = mountainArr.get(currentIndex)

            when {
                current == target -> return currentIndex
                current < target -> low = currentIndex + 1
                else -> high = currentIndex - 1
            }
        }

        low = peakIndex + 1
        high = n - 1

        while (low <= high) {
            val currentIndex = (low + high) shr 1
            val current = mountainArr.get(currentIndex)

            when {
                current == target -> return currentIndex
                current > target -> low = currentIndex + 1
                else -> high = currentIndex - 1
            }
        }

        return -1
        
    }
}

