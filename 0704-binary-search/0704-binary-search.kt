class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left: Int = 0
        var right: Int = nums.size - 1
        var mid: Int

        while (left <= right) {
            mid = left + ((right - left) / 2)
            when {
                nums[mid] == target -> return mid
                nums[mid] < target -> left = mid + 1
                nums[mid] > target -> right = mid - 1
            }
        }

        return -1
    }
}
