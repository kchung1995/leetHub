class Solution {
    fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
        val n = quality.size
        var qualityRadio: MutableList<Pair<Double, Int>> = mutableListOf()

        for (i in 0 until n) {
            val temp = wage[i].toDouble() / quality[i].toDouble()
            qualityRadio.add(Pair(temp, quality[i]))
        }
        qualityRadio.sortBy { it.first }
        qualityRadio.forEach {
            println(it)
        }

        var totalCost: Double = Double.MAX_VALUE
        var totalQuality: Double = 0.0

        val workers = PriorityQueue<Int>(Collections.reverseOrder())
        for (i in 0 until n) {
            val quality = qualityRadio[i].second
            workers.add(quality)
            totalQuality += quality

            if (workers.size > k) totalQuality -= workers.poll()
            if (workers.size == k) {
                totalCost = minOf(totalCost, totalQuality * qualityRadio[i].first)
            }
        }

        return totalCost
    }
}

