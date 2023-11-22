class Solution {
    fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(0, 0))
        val collect = ArrayList<Int>()

        while (queue.isNotEmpty()) {
            val p = queue.poll()
            val row = p.first
            val column = p.second
            collect.add(nums[row][column])

            if (column == 0 && row + 1 < nums.size) {
                queue.add(Pair(row + 1, column))
            }

            if (column + 1 < nums[row].size) {
                queue.add(Pair(row, column + 1))
            }
        }

        val result = IntArray(collect.size)
        var i: Int = 0
        for (number in collect) {
            result[i] = number
            i++
        }

        return result
    }
}

