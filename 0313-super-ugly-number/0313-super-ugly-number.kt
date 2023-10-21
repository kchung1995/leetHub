class Solution {
    fun nthSuperUglyNumber(n: Int, primes: IntArray): Int {
        val p = primes.size
        val indices = IntArray(p)
        val uglyNums = LongArray(n) { 0 }
        uglyNums[0] = 1

        for (i in 1 until n) {
            val nexts = LongArray(p) { uglyNums[indices[it]] * primes[it].toLong() }
            val next = nexts.min()
            for (j in 0 until p) {
                if (next == nexts[j]) {
                    indices[j]++
                }
            }
            uglyNums[i] = next
        }

        return uglyNums[n - 1].toInt()
    }
}

