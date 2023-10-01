data class WorkedTime(val id: Int, val workedTime: Int) : Comparable<WorkedTime> {
    override fun compareTo(other: WorkedTime): Int {
        if (this.workedTime == other.workedTime) return this.id.compareTo(other.id)
        return other.workedTime.compareTo(this.workedTime)
    }
}

class Solution {
    fun hardestWorker(n: Int, logs: Array<IntArray>): Int {
        val maxWorkedTime = IntArray(n) { 0 }
        var lastEndedTime: Int = 0

        for (i in logs) {
            val id = i[0]
            val leaveTime = i[1]
            val currentWorkedTime = leaveTime - lastEndedTime
            maxWorkedTime[id] = maxOf(maxWorkedTime[id], currentWorkedTime)
            lastEndedTime = leaveTime
        }

        val times = maxWorkedTime.mapIndexed { index, time ->
            WorkedTime(id = index, workedTime = time)
        }.sorted()

        return times[0].id
    }
}
