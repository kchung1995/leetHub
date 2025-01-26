class Solution {
    fun judgeCircle(moves: String): Boolean {
        val displacement = IntArray(2) { 0 }
        moves.forEach { move ->
            move(move, displacement)
        }

        return displacement[0] == 0 && displacement[1] == 0
    }

    private fun move(move: Char, displacement: IntArray) {
        when (move) {
            'D' -> displacement[0]++
            'U' -> displacement[0]--
            'R' -> displacement[1]++
            'L' -> displacement[1]--
            else -> throw IllegalArgumentException("What is going on")
        }
    }
}

