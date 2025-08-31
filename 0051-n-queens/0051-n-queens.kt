class Solution {
    companion object {
        private const val DOT = '.'
        private const val Q = 'Q'
    }

    private var size: Int = 0

    fun solveNQueens(n: Int): List<List<String>> {
        size = n
        val board = Array(size) { CharArray(size) { DOT } }
        val result = mutableListOf<List<String>>()

        backtrack(
            row = 0,
            diagonals = mutableSetOf(),
            antiDiagonals = mutableSetOf(),
            columns = mutableSetOf(),
            state = board,
            result = result
        )

        return result
    }

    private fun createBoard(state: Array<CharArray>): List<String> {
        return List(size) { row -> String(state[row]) }
    }

    private fun backtrack(
        row: Int,
        diagonals: MutableSet<Int>,
        antiDiagonals: MutableSet<Int>,
        columns: MutableSet<Int>,
        state: Array<CharArray>,
        result: MutableList<List<String>>
    ) {
        if (row == size) {
            result.add(createBoard(state))
            return
        }
        
        for (column in 0 until size) {
            val currentDiagonal = row - column
            val currentAntiDiagonal = row + column

            if (column in columns || currentDiagonal in diagonals || currentAntiDiagonal in antiDiagonals) continue

            columns.add(column)
            diagonals.add(currentDiagonal)
            antiDiagonals.add(currentAntiDiagonal)
            state[row][column] = Q

            backtrack(
                row = row + 1,
                diagonals = diagonals,
                antiDiagonals = antiDiagonals,
                columns = columns,
                state = state,
                result = result
            )

            columns.remove(column)
            diagonals.remove(currentDiagonal)
            antiDiagonals.remove(currentAntiDiagonal)
            state[row][column] = DOT
        }
    }
}

