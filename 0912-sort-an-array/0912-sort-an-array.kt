class Solution {
    fun getPartition(nums: IntArray, front: Int, back: Int): Int {
        val pivot = nums[back]
        var partition = front
        
        for (i in front until back) {
            if (nums[i] >= pivot) continue
            val temp = nums[partition]
            nums[partition++] = nums[i]
            nums[i] = temp
        }
        val temp = nums[partition]
        nums[partition] = nums[back]
        nums[back] = temp
        
        return partition
    }
    
    fun quickSort(nums: IntArray, front: Int, back: Int) {
        if (front >= back) return
        val partition = getPartition(nums, front, back)
        quickSort(nums, front, partition - 1)
        quickSort(nums, partition + 1, back)
    }
    
    fun sortArray(nums: IntArray): IntArray {
        quickSort(nums, 0, nums.size - 1)
        return nums
    }
}