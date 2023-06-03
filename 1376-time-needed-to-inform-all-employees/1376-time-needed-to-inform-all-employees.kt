class Solution {
    fun numOfMinutes(n: Int, headID: Int, manager: IntArray, informTime: IntArray): Int {
        val finallyInformedTime = mutableListOf<Int>()
        val employees = HashMap<Int, MutableList<Int>>()

        for (i in 0 until n) {
            if (manager[i] == -1) continue
            employees[manager[i]]?.let { employees[manager[i]]!!.add(i) }
                ?: employees.put(manager[i], mutableListOf(i))
        }

        informToSubordinates(0, headID, informTime, employees, finallyInformedTime)
        return finallyInformedTime.max() ?: 0
    }

    private fun informToSubordinates(time: Int, currentEmployee: Int, informTime: IntArray, employees: HashMap<Int, MutableList<Int>>, finallyInformedTime: MutableList<Int>) {
        if (!employees.containsKey(currentEmployee) || employees[currentEmployee]!!.isEmpty()) {
            finallyInformedTime.add(time)
            return
        }
        val nextTime = time + informTime[currentEmployee]
        for (next in employees[currentEmployee]!!) {
            informToSubordinates(nextTime, next, informTime, employees, finallyInformedTime)
        }
    }
}

