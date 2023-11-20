class Solution {
    fun garbageCollection(garbage: Array<String>, travel: IntArray): Int {
        val g= garbage.size
        val t = travel.size
        val prefixSum = IntArray(t + 1) { 0 }
        prefixSum[1] = travel[0]
        for (i in 1 until t) {
            prefixSum[i + 1] = prefixSum[i] + travel[i]
        }

        val garbageLastPosition = HashMap<Char, Int>()
        val garbageCount = HashMap<Char, Int>()

        for (i in 0 until g) {
            for (c in garbage[i]) {
                garbageLastPosition.put(c, i)
                garbageCount.put(c, (garbageCount[c] ?: 0) + 1)
            }
        }

        var result: Int = 0
        listOf('M', 'P', 'G').forEach { c ->
            if (garbageCount.containsKey(c)) {
                result += prefixSum[garbageLastPosition[c]!!] + garbageCount[c]!!
            }
        }

        return result
    }
}

