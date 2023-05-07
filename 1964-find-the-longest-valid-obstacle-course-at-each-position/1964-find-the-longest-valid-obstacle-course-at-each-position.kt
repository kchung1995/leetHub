class Solution {
    fun longestObstacleCourseAtEachPosition(obstacles: IntArray): IntArray {
        val n = obstacles.size
        val result = IntArray(n)
        result[0] = 1
        val list = mutableListOf<Int>(obstacles[0])

        for (i in 1 until n) {
            val current = obstacles[i]
            when {
                current >= list.last() -> {
                    list.add(current)
                    result[i] = list.size
                }
                else -> {
                    val idx = bisectRight(list, current)
                    list[idx] = current
                    result[i] = idx + 1
                }
            }
        }

        return result
    }

    private fun bisectRight(list: List<Int>, target: Int): Int {
        var left = 0
        var right = list.size - 1

        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                list[mid] <= target -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return left
    }
}

