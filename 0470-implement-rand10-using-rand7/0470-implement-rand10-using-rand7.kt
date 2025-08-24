/**
 * The rand7() API is already defined in the parent class SolBase.
 * fun rand7(): Int {}
 * @return a random integer in the range 1 to 7
 */
class Solution : SolBase() {
    fun rand10(): Int {
        var row: Int = 0
        var column: Int = 0
        var idx: Int = 0

        do {
            row = rand7()
            column = rand7()
            idx = column + (row - 1) * 7
        } while (idx > 40)

        return 1 + (idx - 1) % 10
    }
}

