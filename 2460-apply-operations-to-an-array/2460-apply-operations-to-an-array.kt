class Solution {
    fun applyOperations(nums: IntArray): IntArray {
        
        val q: Queue<Int> = LinkedList<Int>()
        
        for (i in 0 until nums.lastIndex) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2
                nums[i + 1] = 0
            }
            if (nums[i] != 0) q.add(nums[i])
        }
        if (nums[nums.lastIndex] != 0) q.add(nums[nums.lastIndex])
        
        val result = IntArray(nums.size) { 0 }
        var index = 0
        while(!q.isEmpty()) {
            result[index++] = q.poll()
        }
        
        return result
    }
}