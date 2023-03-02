class Solution {
    fun convertListToArray(list: MutableList<Char>, array: CharArray) {
        for (i in 0 until list.size) {
            array[i] = list[i]
        }
    }
    
    fun compress(chars: CharArray): Int {
        var left: Int = 0
        var right: Int = 1
        
        if (chars.size == 1) return 1
        
        var currentAppearCount: Int = 1
        val resultList = mutableListOf<Char>()
        while (right < chars.size) {
            if (chars[right] == chars[left]) {
                currentAppearCount++
            }
            else {
                when (currentAppearCount) {
                    1 -> {
                        resultList.add(chars[left])
                    }
                    else -> {
                        val countString = currentAppearCount.toString()
                        resultList.add(chars[left])
                        for (i in countString) {
                            resultList.add(i)
                        }
                    }
                }
                currentAppearCount = 1
                left = right
            }
            right++
        }
        val countString = currentAppearCount.toString()
        resultList.add(chars[left])
        if (countString != "1") {
            for (i in countString) {
                resultList.add(i)
            }
        }
        
        convertListToArray(resultList, chars)
        return resultList.size
    }
}