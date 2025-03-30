class Solution {
    fun survivedRobotsHealths(positions: IntArray, healths: IntArray, directions: String): List<Int> {
        val n = positions.size
        val indices = (0 until n).toMutableList()
            .apply { sortBy { positions[it] } }
        val result = mutableListOf<Int>()
        val stack = ArrayDeque<Int>()

        for (currentIndex in indices) {
            if (directions[currentIndex] == 'R') {
                stack.addLast(currentIndex)
            } else {
                while (stack.isNotEmpty() && healths[currentIndex] > 0) {
                    val topIndex = stack.removeLast()
                    when {
                        healths[topIndex] > healths[currentIndex] -> {
                            healths[topIndex] -= 1
                            healths[currentIndex] = 0
                            stack.addLast(topIndex)
                        }
                        healths[topIndex] < healths[currentIndex] -> {
                            healths[currentIndex] -= 1
                            healths[topIndex] = 0
                        }
                        else -> {
                            healths[currentIndex] = 0
                            healths[topIndex] = 0
                        }
                    }
                }
            }
        }

        for (i in 0 until n) {
            if (healths[i] > 0) result.add(healths[i])
        }
        return result
    }
}

