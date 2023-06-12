class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        var from: Int = 0
        var prev: Int = 0

        if (nums.isEmpty()) return emptyList<String>()

        val result = mutableListOf<String>()
        from = nums[0]
        prev = nums[0]
        for (i in 1 until nums.size) {
            if (nums[i] != prev + 1) {
                if (from == prev) result.add(prev.toString())
                else result.add("$from->$prev")
                from = nums[i]
                prev = nums[i]
            }
            else prev = nums[i]
        }
        
        if (from == prev) result.add(prev.toString())
        else result.add("$from->$prev")

        return result
    }
}

