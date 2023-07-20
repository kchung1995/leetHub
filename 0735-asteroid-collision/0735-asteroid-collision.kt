class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val s = Stack<Int>()
        val result = mutableListOf<Int>()

        val originalSize = asteroids.size

        for (i in originalSize - 1 downTo 0) {
            s.push(asteroids[i])
        }

        while (s.isNotEmpty()) {
            val first = s.pop()
            if (s.isEmpty()) {
                result.add(first)
                continue
            }
            val second = s.pop()

            if (isSameDirection(first, second)) {
                result.add(first)
                s.push(second)
                continue
            }

            if (first > 0 && second < 0) {
                val firstMass = Math.abs(first)
                val secondMass = Math.abs(second)

                when {
                    firstMass > secondMass -> s.push(first)
                    firstMass < secondMass -> s.push(second)
                }
            } else {
                result.add(first)
                s.add(second)
            }
        }

        if (originalSize != result.size) return asteroidCollision(result.toIntArray())
        return result.toIntArray()
    }

    private fun isSameDirection(first: Int, second: Int): Boolean {
        return (first < 0 && second < 0) || (first > 0 && second > 0)
    }
}
