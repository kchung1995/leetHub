class Solution {
    fun isMonotonic(nums: IntArray): Boolean {
        var currentOrder = Ordering.UNKNOWN

        for (i in 0 until nums.size - 1) {
            val target = Ordering.convert(nums[i].compareTo(nums[i + 1]))
            if (currentOrder == Ordering.INCREASE && target == Ordering.DECREASE) return false
            if (currentOrder == Ordering.DECREASE && target == Ordering.INCREASE) return false
            if (currentOrder == Ordering.UNKNOWN) currentOrder = target
        }

        return true
    }

    enum class Ordering {
        INCREASE,
        DECREASE,
        UNKNOWN
        ;

        companion object {
            fun convert(compared: Int) = when(compared) {
                -1 -> INCREASE
                0 -> UNKNOWN
                1 -> DECREASE
                else -> throw IllegalArgumentException()
            }
        }
    }
}

