class Solution {
    fun furthestBuilding(heights: IntArray, bricksOriginal: Int, laddersOriginal: Int): Int {
        val h = heights.size
        var bricks: Int = bricksOriginal
        var ladders: Int = laddersOriginal
        val bricksPlacing: Queue<Int> = PriorityQueue<Int>(compareBy { -it } )

        for (i in 0 until h - 1) {
            val climb = heights[i + 1] - heights[i]

            if (climb <= 0) continue

            bricksPlacing.add(climb)
            bricks -= climb

            if (bricks < 0 && ladders == 0) return i

            if (bricks < 0) {
                bricks += bricksPlacing.remove()
                ladders--
            }
        }
        
        return h - 1
    }
}

