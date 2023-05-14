class Solution {
    fun taskSchedulerII(tasks: IntArray, space: Int): Long {
        val nextAvailableTask = HashMap<Int, Long>()
        var result: Long = 0

        for (task in tasks) {
          result = maxOf(result + 1, nextAvailableTask[task] ?: 0L)
          nextAvailableTask.put(task, result + space + 1)
        }

        return result
    }
}

