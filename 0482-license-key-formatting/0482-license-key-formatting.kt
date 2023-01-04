class Solution {
    fun licenseKeyFormatting(s: String, k: Int): String {
        val sup = s.toUpperCase();
        
        val sb = StringBuilder()
        var i = sup.length - 1
        var j = 0
        
        while(i >= 0) {
            val c = sup[i]
            
            if (c == '-') {
                i--
                continue
            }
            
            sb.insert(0, c)
            j++
            if (j == k) {
                sb.insert(0, '-')
                j = 0
            }
            i--
        }
        
        if (sb.length > 0 && sb[0] == '-') {
            sb.deleteCharAt(0)
        }
        
        return sb.toString()
    }
}