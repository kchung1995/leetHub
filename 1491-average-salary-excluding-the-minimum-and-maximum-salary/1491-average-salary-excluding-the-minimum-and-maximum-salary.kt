class Solution {
    fun average(salary: IntArray): Double {
        salary.sort()
        var result: Int = 0
        for (i in 1 until salary.size - 1) {
            result += salary[i]
        }
        return (result.toDouble()) / (salary.size - 2).toDouble()
    }
}

