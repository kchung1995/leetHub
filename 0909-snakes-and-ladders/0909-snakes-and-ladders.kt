class Solution {
    fun snakesAndLadders(board: Array<IntArray>): Int {
        val n = board.size
        val total = n * n
        var result: Int = Integer.MAX_VALUE

        val queue = ArrayDeque<Pair<Int, Int>>()
        val hasVisited = BooleanArray(total + 1)
        queue.add(1 to 0)
        hasVisited[1] = true
        
        while (queue.isNotEmpty()) {
            val (currentSquare, moves) = queue.removeFirst()
            if (currentSquare == total) {
                result = minOf(result, moves)
                continue
            }
            
            for (diceRolled in 1..6) {
                val nextSquare = currentSquare + diceRolled
                if (nextSquare > total) break
                
                val (xPos, yPos) = getCoordinates(nextSquare, n)
                val destination = if (board[xPos][yPos] != -1) board[xPos][yPos] else nextSquare
                
                if (hasVisited[destination].not()) {
                    hasVisited[destination] = true
                    queue.add(destination to moves + 1)
                }
            }
        }

        return if (result == Integer.MAX_VALUE) -1 else result
    }
    
    private fun getCoordinates(squareNumber: Int, n: Int): Pair<Int, Int> {
        val quotient = (squareNumber - 1) / n 
        val remainder = (squareNumber - 1) % n

        val xPos = n - 1 - quotient
        val yPos = if (quotient % 2 == 0) remainder else n - 1 - remainder
        return Pair(xPos, yPos)
    }
}
