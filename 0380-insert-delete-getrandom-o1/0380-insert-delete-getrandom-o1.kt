class RandomizedSet() {

    private val randomizedSet = HashSet<Int>()

    fun insert(value: Int): Boolean {
        val wasPresent: Boolean = randomizedSet.contains(value).not()
        randomizedSet.add(value)
        return wasPresent
    }

    fun remove(value: Int): Boolean {
        val wasPresent: Boolean = randomizedSet.contains(value)
        if (wasPresent) randomizedSet.remove(value)
        return wasPresent
    }

    fun getRandom(): Int {
        return randomizedSet.shuffled()[0]
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */
