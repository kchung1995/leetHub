class MyHashSet() {
    private val SIZE = 1000000
    private val buckets: Array<MutableList<Int>> = Array(SIZE) { mutableListOf<Int>() }

    fun add(key: Int) {
        val bucketIndex = getBucketIndex(key)
        if (!contains(key)) {
            buckets[bucketIndex].add(key)
        }
    }

    fun remove(key: Int) {
        val bucketIndex = getBucketIndex(key)
        buckets[bucketIndex].remove(key)
    }

    fun contains(key: Int): Boolean {
        val bucketIndex = getBucketIndex(key)
        return key in buckets[bucketIndex]
    }

    private fun getBucketIndex(key: Int): Int {
        return key % SIZE
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */

