class Solution {
    fun max (a: Int, b: Int): Int {
        if (a > b) return a
        return b
    }
    
    fun totalFruit(fruits: IntArray): Int {
        
        if (fruits.size == 1)
            return 1

        val fruitsCount: HashMap<Int, Int> = HashMap<Int, Int>()
        var result = 0
        var previous = 0
        
        for (i in fruits) {
            if (fruitsCount.containsKey(i)) {
                fruitsCount[i] = fruitsCount[i]!! + 1
            }
            else {
                fruitsCount.put(i, 1)
            }
            
            if (fruitsCount.size > 2) {
                fruitsCount[fruits[previous]] = fruitsCount[fruits[previous]]!! - 1
                if (fruitsCount[fruits[previous]]!! == 0) {
                    fruitsCount.remove(fruits[previous])
                }
                previous++
            } 
            else {
                result = max(result, fruitsCount.values.sum())
            }
        }
        
        return result
        
    }
}