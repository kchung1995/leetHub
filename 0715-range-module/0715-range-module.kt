class RangeModule() {

    private val ranges = TreeMap<Int, Int>()

    fun addRange(left: Int, right: Int) {
        var leftr = left
        var rightr = right

        val l = ranges.floorKey(left)
        val r = ranges.floorKey(right)

        if (l != null && ranges[l]!! >= leftr)
            leftr = l
        if (r != null && ranges[r]!! > rightr)
            rightr = ranges[r]!!

        ranges.subMap(leftr, rightr).clear()
        ranges[leftr] = rightr
    }

    fun queryRange(left: Int, right: Int): Boolean {
        val l = ranges.floorKey(left)
        return l != null && ranges[l]!! >= right
    }

    fun removeRange(left: Int, right: Int) {
        val l = ranges.floorKey(left)
        val r = ranges.floorKey(right)

        if (r != null && ranges[r]!! > right)
            ranges[right] = ranges[r]!!
        if (l != null && ranges[l]!! > left)
            ranges[l] = left

        ranges.subMap(left, right).clear()
    }

}

/**
 * Your RangeModule object will be instantiated and called as such:
 * var obj = RangeModule()
 * obj.addRange(left,right)
 * var param_2 = obj.queryRange(left,right)
 * obj.removeRange(left,right)
 */
