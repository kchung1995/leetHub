class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val n = nums.size
        var prefixMod: Int = 0
        val modSeen = HashMap<Int, Int>()
        modSeen.put(0, -1)

        for (i in 0 until n) {
            prefixMod = (prefixMod + nums[i]) % k
            if (modSeen.containsKey(prefixMod)) {
                if (i - modSeen[prefixMod]!! > 1) return true
            }
            else modSeen.put(prefixMod, i)
        }

        return false
    }
}

