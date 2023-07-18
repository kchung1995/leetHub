class LRUCache(capacity: Int) {
    val limit = capacity
    val map = IntArray(10001) { -1 }
    val keys = mutableListOf<Int>()

    fun get(key: Int): Int {
        val value = map[key]
        if (value != -1) {
            keys.remove(key)
            keys.add(key)
        }
        return value

    }

    fun put(key: Int, value: Int) {
        map[key] = value
        keys.remove(key)
        keys.add(key)
        if (keys.size > limit) {
            map[keys[0]] = -1
            keys.removeAt(0)
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */
