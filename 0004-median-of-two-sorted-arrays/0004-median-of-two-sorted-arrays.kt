class Solution {
    var nums1Index: Int = 0
    var nums2Index: Int = 0
    var currentElementCount: Int = 0

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val n = nums1.size
        val m = nums2.size
        val isEven = (n + m) % 2 == 0
        val targetCount = (n + m) / 2
        var result: Int = 0
        var previousValue = 0

        while (currentElementCount <= targetCount) {
            previousValue = result
            result = getMinValue(nums1, nums2)
            currentElementCount++
        }
        if (isEven) result += previousValue

        return if (isEven.not()) result.toDouble() else result.toDouble() / 2.0
    }

    private fun getMinValue(nums1: IntArray, nums2: IntArray): Int {
        var result: Int = 0

        if (nums1Index == nums1.size) {
            result = nums2[nums2Index]
            nums2Index++
            return result
        }
        if (nums2Index == nums2.size) {
            result = nums1[nums1Index]
            nums1Index++
            return result
        }

        if (nums1[nums1Index] <= nums2[nums2Index]) {
            result = nums1[nums1Index]
            nums1Index++
        }
        else {
            result = nums2[nums2Index]
            nums2Index++
        }
        return result
    }
}

