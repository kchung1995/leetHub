class Solution {
    fun numberOfBeams(banks: Array<String>): Int {
        var result: Int = 0

        var previous: Int = 0
        for (bank in banks) {
            var onesCount: Int = 0
            for (bankChar in bank) {
                if (bankChar == '1') onesCount++
            }

            if (onesCount > 0) {
                result += (previous * onesCount)
                previous = onesCount
            }
        }

        return result
    }
}

