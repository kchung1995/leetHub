class Solution {
    fun maxChunksToSorted(arr: IntArray): Int {
        val count = HashMap<Int, Int>()
        val counted = mutableListOf<ValueAndCount>()

        for (x in arr) {
            count.put(x, count.getOrDefault(x, 0) + 1)
            counted.add(ValueAndCount(x, count[x]!!))
        }

        val expected = counted.map { it.copy() }
            .sortedWith(Comparator { p1, p2 ->
                p1.compare(p2)
            })
        
        var currentValueAndCount = counted[0]!!
        var result: Int = 0
        for (i in 0 until arr.size) {
            val original = counted[i]!!
            val sorted = expected[i]!!
            
            if (original.compare(currentValueAndCount) > 0) currentValueAndCount = original;
            if (currentValueAndCount.compare(sorted) == 0) result++;
        }

        return result
    }
}

data class ValueAndCount(
    val value: Int,
    val count: Int
) {
    fun compare(other: ValueAndCount): Int {
        return when (this.value != other.value) {
            true -> this.value - other.value
            false -> this.count - other.count
        }
    }
}

