class Solution {
    fun canBePlaced(flowerbed: IntArray, position: Int, e: Int): Boolean {
        if (position == 0)
            if (flowerbed[0] == 0 && flowerbed[1] == 0) return true else return false
        if (position == e)
            if (flowerbed[e] == 0 && flowerbed[e - 1] == 0) return true else return false
        
        if (flowerbed[position] == 0 && flowerbed[position - 1] == 0 && flowerbed[position + 1] == 0) return true
        return false
    }
    
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        val e = flowerbed.size - 1
        var remaining: Int = n
        
        if (e == 0) {
            if (flowerbed[0] == 0) {
                if (n == 0 || n == 1) return true
                return false
            }
            if (flowerbed[0] == 1) {
                if (n == 0) return true
                return false
            }
        }
        
        for (i in flowerbed.indices) {
            if (canBePlaced(flowerbed, i, e)) {
                remaining--
                flowerbed[i] = 1
            }
        }
        
        if (remaining <= 0) return true
        return false
    }
}
