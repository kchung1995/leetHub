class Solution {
    fun sortArray(nums: IntArray): IntArray {
        val n = nums.size
        val subNums = IntArray(n)
        nums.mergeSort(left = 0, right = n - 1, subNums)

        return nums
    }

    private fun IntArray.mergeSort(left: Int, right: Int, subNums: IntArray) {
        if (left >= right) return
        
        val mid = left + (right - left) / 2
        this.mergeSort(left, mid, subNums)
        this.mergeSort(mid + 1, right, subNums)
        this.merge(left, mid, right, subNums)
    }

    private fun IntArray.merge(left: Int, mid: Int, right: Int, subNums: IntArray) {
        val startLeft = left
        val startRight = mid + 1
        val n1 = mid - left + 1
        val n2 = right - mid

        (0 until n1).forEach { i ->
            subNums[startLeft + i] = this[startLeft + i]
        }
        (0 until n2).forEach { i ->
            subNums[startRight + i] = this[startRight + i]
        }

        var i: Int = 0
        var j: Int = 0
        var k: Int = left
        while (i < n1 && j < n2) {
            if (subNums[startLeft + i] <= subNums[startRight + j]) {
                this[k] = subNums[startLeft + i]
                i++
            }
            else {
                this[k] = subNums[startRight + j]
                j++
            }
            k++
        }
        while (i < n1) {
            this[k] = subNums[startLeft + i];
            i++
            k++
        }
        while (j < n2) {
            this[k] = subNums[startRight + j];
            j++
            k++
        }
    }
}

