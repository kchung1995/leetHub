class Solution {
    val MOD: Long = 1000000007

    fun countNicePairs(nums: IntArray): Int {
        val n = nums.size
        val revNums = nums.map { rev(it) }
        val diffs = (0 until n).map { nums[it] - revNums[it] }

        val numsCount = HashMap<Int, Int>()
        diffs.forEach { diff ->
            if (numsCount.containsKey(diff).not()) numsCount[diff] = 1
            else numsCount[diff] = numsCount[diff]!! + 1
        }

        val result = numsCount.map { (key, value) ->
            if (value == 1) 0L else summation((value - 1).toLong()) % MOD
        }.sum().toInt() % MOD.toInt()


        return result
    }

    private fun rev(num: Int): Int {
        var currentNum = num
        var result: Int = 0

        while (currentNum != 0) {
            val digit = currentNum % 10
            result = (result * 10) + digit
            currentNum /= 10
        }

        return result
    }

    private fun summation(n: Long): Long {
        return (n * (n + 1)) / 2
    }
}

