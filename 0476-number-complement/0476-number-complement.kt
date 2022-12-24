class Solution {

    fun getPow(input: Int, power: Int): Int {
        if (power == 0) {
            return 1
        }
        
        var result: Int = 1;
        for (i in 1..power) {
            result *= input
        }
        
        return result
    }
    
    fun decimalToBinary(nums : Int): String {
        var result: String = ""
        var num = nums
        
        while(num >= 2) {
            result = (num % 2).toString() + result
            num /= 2
        }
        
        result = num.toString() + result
        return result
    }
    
    fun binaryComplementToDecimal(input: String): Int {
        var result: Int = 0
        
        for(i in 0 until input.length) {
            if (input.get(input.length - 1 - i) == '0') {
                result += getPow(2, i)
            }
        }
        
        return result
    }
    
    fun findComplement(num: Int): Int {
        return binaryComplementToDecimal(decimalToBinary(num))
    }
}