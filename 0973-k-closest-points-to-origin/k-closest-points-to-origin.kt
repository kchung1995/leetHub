class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        points.sortBy { it.distance() }
        return points.copyOfRange(0, k)
    }

    private fun IntArray.distance() = this[0].square() + this[1].square()

    private fun Int.square() = this * this
}

