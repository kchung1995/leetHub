class Solution {
    fun isAlone(nums: IntArray, i: Int): Boolean {
        if (i == 0) {
            if (nums[i] != nums[i + 1]) return true
        }
        if (i == nums.size - 1) {
            if (nums[i] != nums[i - 1]) return true
        }
        if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) return true
        return false
    }
    
    fun binarySearch(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        
        var start = 0
        var end = nums.size - 1
        var mid = -1
        
        while (start <= end) {
            mid = (start + end) / 2
            if (isAlone(nums, mid)) return nums[mid]
            
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid - 1]) {
                    end = mid - 1
                }
                else if (nums[mid] == nums[mid + 1]) {
                    start = mid + 1
                }
            }
            else {
                if (nums[mid] == nums[mid + 1]) {
                    end = mid - 1
                }
                else if (nums[mid] == nums[mid - 1]) {
                    start = mid + 1
                }
            }
        }
        return nums[mid]
    }
    
    fun singleNonDuplicate(nums: IntArray): Int {
        return binarySearch(nums)
    }
}