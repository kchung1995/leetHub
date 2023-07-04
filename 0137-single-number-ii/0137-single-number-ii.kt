class Solution {
    fun singleNumber(nums: IntArray): Int {
        val map = HashMap<Int, Int>()
        for (i in nums) {
            if (map.containsKey(i)) map[i] = map[i]!! + 1 else map.put(i, 1)
        }
        
        map.forEach {
            if (it.value == 1) return it.key
        }
        return -1
    }
}

