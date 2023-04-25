class SmallestInfiniteSet() {
    private val infiniteSet: MutableSet<Int> = TreeSet()
    private var current: Int = 1

    fun popSmallest(): Int {
        if(infiniteSet.isEmpty()) {
            return current++
        }
        val min = infiniteSet.first()
        infiniteSet.remove(min)
        return min
    }

    fun addBack(num: Int) {
        if (num < current) infiniteSet.add(num)
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * var obj = SmallestInfiniteSet()
 * var param_1 = obj.popSmallest()
 * obj.addBack(num)
 */

