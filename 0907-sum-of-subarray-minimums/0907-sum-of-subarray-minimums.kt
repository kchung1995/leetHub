class Solution {
    companion object {
        val MOD = 1000000007
    }

    fun sumSubarrayMins(arr: IntArray): Int {
        val n = arr.size
        val stack = Stack<Int>()
        var sumOfMinimums: Long = 0

        for (i in 0 .. n) {
            while (stack.isNotEmpty() && (i == n || arr[stack.peek()] >= arr[i])) {
                val mid = stack.pop()
                val leftBoundary = if (stack.isEmpty()) -1 else stack.peek()
                val rightBoundary = i

                val count = (mid - leftBoundary) * (rightBoundary - mid) % MOD

                sumOfMinimums += (count.toLong() * arr[mid].toLong()) % MOD
                sumOfMinimums %= MOD
            }
            stack.push(i)
        }

        return sumOfMinimums.toInt()
    }
}

