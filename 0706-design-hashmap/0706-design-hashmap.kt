data class Map(val key: Int, val value: Int)

class MyHashMap() {
    val hashTable = Array<MutableList<Map>>(1000) { mutableListOf<Map>() }

    fun put(key: Int, value: Int) {
        val hashValue = hashFunction(key)
        remove(key)
        hashTable[hashValue].add(Map(key, value))
    }

    fun get(key: Int): Int {
        val hashValue = hashFunction(key)
        return hashTable[hashValue].find { it.key == key }?.value ?: -1
    }

    fun remove(key: Int) {
        val hashValue = hashFunction(key)
        hashTable[hashValue].removeIf { it.key == key }
    }

    private fun hashFunction(input: Int): Int = input % 1000
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */
