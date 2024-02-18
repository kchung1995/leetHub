class Solution {
    fun maxResult(nums: IntArray, k: Int): Int {
        val n = nums.size
        val score = IntArray(n)
        score[0] = nums[0]

        val pq = PriorityQueue<IntArray> { a, b -> b[0] - a[0] }
        pq.add(intArrayOf(nums[0], 0))

        for (i in 1 until n) {
            while (pq.peek()[1] < i - k) {
                pq.remove()
            }
            score[i] = nums[i] + score[pq.peek()[1]]
            pq.add(intArrayOf( score[i], i))
        }

        return score[n - 1]
    }
}

