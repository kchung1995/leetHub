class Solution {
    fun binarySearch(nums: IntArray, target: Int): Int {
        var start: Int = 0
        var end: Int = nums.size - 1
        var mid: Int = -1
        
        while (start < end) {
            mid = (start + end) / 2
            when {
                nums[mid] == target -> return mid
                nums[mid] < target -> start = mid + 1
                nums[mid] > target -> end = mid - 1
            }
        }
        
        mid = (start + end) / 2
        return when {
            nums[mid] < target -> mid + 1
            nums[mid] > target -> mid
            else -> mid
        }
    }
    
    fun searchInsert(nums: IntArray, target: Int): Int {
        return binarySearch(nums, target)
    }
}