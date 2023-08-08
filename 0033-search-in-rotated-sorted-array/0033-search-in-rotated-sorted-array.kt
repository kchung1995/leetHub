class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val n = nums.size
        var left = 0
        var right = n - 1
        var mid = -1
        
        while (left <= right) {
            mid = left + (right - left) / 2
            
            if (nums[mid] == target) return mid
            
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) right = mid - 1
                else left = mid + 1
            }
            else {
                if (target <= nums[right] && target > nums[mid]) left = mid + 1
                else right = mid - 1
            }
        }
        
        return -1
    }
}

