class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val n = nums[0].length.toLong()
        val numbers = nums.map { 
            println(it.toLong())
            it.toLong() }.toSet()

        for (i in 0L..n) {
            if (numbers.contains(i).not()) {
                var binary =  java.lang.Long.toBinaryString(i)
                println("i: $i, binary = $binary")
                while (binary.length < n) binary = '0' + binary
                return binary
            }
        }

        return ""
    }
}

